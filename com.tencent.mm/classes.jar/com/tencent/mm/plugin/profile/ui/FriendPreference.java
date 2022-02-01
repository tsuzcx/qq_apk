package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.f;
import com.tencent.mm.modelavatar.f.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import junit.framework.Assert;

public class FriendPreference
  extends Preference
  implements AvatarStorage.a
{
  private TextView MXN;
  private ImageView MXO;
  private ImageView MXP;
  private com.tencent.mm.plugin.account.friend.model.a MXQ;
  private String MXR;
  private long MXS;
  private long MXT;
  private au contact;
  private int hUr;
  private MMActivity lzt;
  private String pQw;
  private TextView titleTv;
  private boolean yxr;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27235);
    this.lzt = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27235);
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27236);
    setLayoutResource(R.i.mm_preference);
    aBp(R.i.mm_preference_submenu);
    init();
    AppMethodBeat.o(27236);
  }
  
  private void gBN()
  {
    AppMethodBeat.i(27240);
    if ((this.contact == null) || (!this.yxr))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.yxr);
      AppMethodBeat.o(27240);
      return;
    }
    this.hUr = 3;
    this.titleTv.setText(this.mContext.getString(R.l.hardcode_plugin_facebookapp_nick));
    this.MXN.setText(Util.nullAsNil(this.contact.jZZ));
    Object localObject1 = d.Lv(this.MXT);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label366:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.f.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        Log.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label366;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(27240);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          Log.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 78, 78, false);
        if (localObject4 != localObject1)
        {
          Log.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject4, true, 0.0F);
        this.MXO.setImageBitmap((Bitmap)localObject1);
      }
      bh.bCz();
      if (!c.isSDCardAvailable()) {
        this.MXO.setBackgroundDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.default_avatar));
      }
      AppMethodBeat.o(27240);
      return;
    }
  }
  
  private void gBO()
  {
    AppMethodBeat.i(27241);
    if ((this.contact == null) || (!this.yxr))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.yxr);
      AppMethodBeat.o(27241);
      return;
    }
    this.hUr = 2;
    this.titleTv.setText(this.mContext.getString(R.l.gBs));
    Object localObject1 = Util.nullAsNil(this.MXR);
    localObject1 = (String)localObject1 + " " + new p(this.MXS).longValue();
    this.MXN.setText((CharSequence)localObject1);
    localObject1 = d.iy(this.MXS);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label390:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.f.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        Log.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label390;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(27241);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          Log.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 78, 78, false);
        if (localObject4 != localObject1)
        {
          Log.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject4, true, 0.0F);
        this.MXO.setImageBitmap((Bitmap)localObject1);
      }
      bh.bCz();
      if (!c.isSDCardAvailable()) {
        this.MXO.setBackgroundDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.default_avatar));
      }
      AppMethodBeat.o(27241);
      return;
    }
  }
  
  private void gBP()
  {
    AppMethodBeat.i(27242);
    if ((this.contact == null) || (!this.yxr))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.yxr);
      AppMethodBeat.o(27242);
      return;
    }
    if (this.MXQ == null)
    {
      AppMethodBeat.o(27242);
      return;
    }
    this.hUr = 1;
    this.titleTv.setText(this.mContext.getString(R.l.gBr));
    final String str = Util.nullAsNil(this.MXQ.bWI()) + " " + Util.nullAsNil(this.MXQ.bWN()).replace(" ", "");
    this.MXN.setText(str);
    Bitmap localBitmap = i.a(this.MXQ.bWH(), this.mContext);
    if (localBitmap == null) {
      this.MXO.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.default_mobile_avatar));
    }
    for (;;)
    {
      bh.bCz();
      if (!c.bzA().bxr(this.MXQ.getUsername())) {
        break;
      }
      this.MXP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27233);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).osA))) {}
          for (paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(R.c.fjT);; paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(R.c.fjU))
          {
            localObject = paramAnonymousView;
            if (com.tencent.mm.plugin.profile.b.pFo.aDC())
            {
              paramAnonymousView = Util.stringsToList(paramAnonymousView);
              paramAnonymousView.add(FriendPreference.b(FriendPreference.this).getResources().getString(R.l.gyY));
              localObject = (String[])paramAnonymousView.toArray(new String[paramAnonymousView.size()]);
              h.OAn.b(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
            }
            k.a(FriendPreference.b(FriendPreference.this), null, (String[])localObject, null, new k.d()
            {
              public final void qz(int paramAnonymous2Int)
              {
                AppMethodBeat.i(27232);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(27232);
                  return;
                  if ((FriendPreference.1.this.MXU == null) || (FriendPreference.1.this.MXU.length() == 0))
                  {
                    AppMethodBeat.o(27232);
                    return;
                  }
                  paramAnonymous2Int = FriendPreference.1.this.MXU.lastIndexOf(' ') + 1;
                  if (paramAnonymous2Int > 0)
                  {
                    FriendPreference.a(FriendPreference.this, FriendPreference.1.this.MXU.substring(paramAnonymous2Int));
                    AppMethodBeat.o(27232);
                    return;
                    if ((FriendPreference.1.this.MXU == null) || (FriendPreference.1.this.MXU.length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    paramAnonymous2Int = FriendPreference.1.this.MXU.lastIndexOf(' ');
                    Object localObject = FriendPreference.1.this.MXU.substring(0, paramAnonymous2Int);
                    if ((localObject == null) || (((String)localObject).length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    ab.c(FriendPreference.c(FriendPreference.this), ((String)localObject).trim());
                    AppMethodBeat.o(27232);
                    return;
                    if ((this.rSp == null) || (this.rSp.length <= 2) || (FriendPreference.a(FriendPreference.this) == null) || (FriendPreference.c(FriendPreference.this) == null))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).osA)))
                    {
                      FriendPreference.a(FriendPreference.this, FriendPreference.c(FriendPreference.this).field_username, FriendPreference.a(FriendPreference.this).osA);
                      AppMethodBeat.o(27232);
                      return;
                    }
                    localObject = new Intent();
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("fromScene", 2);
                    ((Intent)localObject).putExtra("reportArgs", localBundle);
                    com.tencent.mm.plugin.profile.b.pFn.i((Intent)localObject, FriendPreference.b(FriendPreference.this));
                  }
                }
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27233);
            return;
          }
        }
      });
      AppMethodBeat.o(27242);
      return;
      localBitmap = BitmapUtil.getRoundedCornerBitmap(Bitmap.createScaledBitmap(localBitmap, 78, 78, false), true, 0.0F);
      this.MXO.setImageBitmap(localBitmap);
    }
    this.MXP.setVisibility(4);
    AppMethodBeat.o(27242);
  }
  
  private void gBQ()
  {
    AppMethodBeat.i(27243);
    if ((this.contact == null) || (!this.yxr))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.yxr);
      AppMethodBeat.o(27243);
      return;
    }
    this.hUr = 3;
    this.titleTv.setText(this.mContext.getString(R.l.regby_email_address));
    this.MXN.setText(Util.nullAsNil(this.pQw));
    this.MXO.setVisibility(8);
    AppMethodBeat.o(27243);
  }
  
  private void init()
  {
    this.yxr = false;
    this.contact = null;
    this.MXQ = null;
    this.MXR = "";
    this.MXS = 0L;
    this.MXT = 0L;
    this.hUr = 0;
    this.pQw = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(27239);
    if ((this.contact == null) || (!this.yxr))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.yxr);
      AppMethodBeat.o(27239);
      return;
    }
    if ((this.MXS != -1L) && (new p(this.MXS).longValue() > 0L))
    {
      aBp(R.i.gmg);
      gBO();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.MXQ != null)
    {
      aBp(R.i.gmd);
      gBP();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.MXT > 0L)
    {
      gBN();
      AppMethodBeat.o(27239);
      return;
    }
    if (!TextUtils.isEmpty(this.pQw))
    {
      gBQ();
      AppMethodBeat.o(27239);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(27239);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27244);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = i.a(paramString, this.mContext, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27244);
      return bool;
    }
    AppMethodBeat.o(27244);
    return false;
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(27246);
    long l = d.Lx(paramString);
    if ((l > 0L) && (this.MXS == l) && (d.a(paramString, false, -1, null) != null)) {
      initView();
    }
    if ((d.Lw(paramString) == this.MXT) && (d.a(paramString, false, -1, null) != null)) {
      initView();
    }
    AppMethodBeat.o(27246);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27238);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.MXN = ((TextView)paramView.findViewById(R.h.summary));
    this.MXO = ((ImageView)paramView.findViewById(R.h.image_iv));
    this.MXP = ((ImageView)paramView.findViewById(R.h.fOm));
    this.yxr = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27238);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27237);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.glQ, localViewGroup);
    AppMethodBeat.o(27237);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */