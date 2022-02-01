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
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.q;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import junit.framework.Assert;

public class FriendPreference
  extends Preference
  implements f.a
{
  private TextView GZI;
  private ImageView GZJ;
  private ImageView GZK;
  private com.tencent.mm.plugin.account.friend.a.a GZL;
  private String GZM;
  private long GZN;
  private long GZO;
  private as contact;
  private int fOy;
  private MMActivity iXq;
  private String mTO;
  private TextView titleTv;
  private boolean vkO;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27235);
    this.iXq = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27235);
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27236);
    setLayoutResource(R.i.mm_preference);
    auN(R.i.mm_preference_submenu);
    init();
    AppMethodBeat.o(27236);
  }
  
  private void fqs()
  {
    AppMethodBeat.i(27240);
    if ((this.contact == null) || (!this.vkO))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.vkO);
      AppMethodBeat.o(27240);
      return;
    }
    this.fOy = 3;
    this.titleTv.setText(this.mContext.getString(R.l.hardcode_plugin_facebookapp_nick));
    this.GZI.setText(Util.nullAsNil(this.contact.hDd));
    Object localObject1 = d.Tt(this.GZO);
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
        this.GZJ.setImageBitmap((Bitmap)localObject1);
      }
      bh.beI();
      if (!c.isSDCardAvailable()) {
        this.GZJ.setBackgroundDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.default_avatar));
      }
      AppMethodBeat.o(27240);
      return;
    }
  }
  
  private void fqt()
  {
    AppMethodBeat.i(27241);
    if ((this.contact == null) || (!this.vkO))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.vkO);
      AppMethodBeat.o(27241);
      return;
    }
    this.fOy = 2;
    this.titleTv.setText(this.mContext.getString(R.l.eyA));
    Object localObject1 = Util.nullAsNil(this.GZM);
    localObject1 = (String)localObject1 + " " + new p(this.GZN).longValue();
    this.GZI.setText((CharSequence)localObject1);
    localObject1 = d.Go(this.GZN);
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
        this.GZJ.setImageBitmap((Bitmap)localObject1);
      }
      bh.beI();
      if (!c.isSDCardAvailable()) {
        this.GZJ.setBackgroundDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.default_avatar));
      }
      AppMethodBeat.o(27241);
      return;
    }
  }
  
  private void fqu()
  {
    AppMethodBeat.i(27242);
    if ((this.contact == null) || (!this.vkO))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.vkO);
      AppMethodBeat.o(27242);
      return;
    }
    if (this.GZL == null)
    {
      AppMethodBeat.o(27242);
      return;
    }
    this.fOy = 1;
    this.titleTv.setText(this.mContext.getString(R.l.eyz));
    final String str = Util.nullAsNil(this.GZL.bxT()) + " " + Util.nullAsNil(this.GZL.bxY()).replace(" ", "");
    this.GZI.setText(str);
    Bitmap localBitmap = l.a(this.GZL.bxS(), this.mContext);
    if (localBitmap == null) {
      this.GZJ.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.default_mobile_avatar));
    }
    for (;;)
    {
      bh.beI();
      if (!c.bbL().bwd(this.GZL.getUsername())) {
        break;
      }
      this.GZK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(27233);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).lAY))) {}
          for (paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(R.c.djS);; paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(R.c.djT))
          {
            localObject = com.tencent.mm.plugin.profile.b.mIH;
            h.a(FriendPreference.b(FriendPreference.this), null, paramAnonymousView, null, new h.d()
            {
              public final void qy(int paramAnonymous2Int)
              {
                AppMethodBeat.i(27232);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(27232);
                  return;
                  if ((FriendPreference.1.this.GZP == null) || (FriendPreference.1.this.GZP.length() == 0))
                  {
                    AppMethodBeat.o(27232);
                    return;
                  }
                  paramAnonymous2Int = FriendPreference.1.this.GZP.lastIndexOf(' ') + 1;
                  if (paramAnonymous2Int > 0)
                  {
                    FriendPreference.a(FriendPreference.this, FriendPreference.1.this.GZP.substring(paramAnonymous2Int));
                    AppMethodBeat.o(27232);
                    return;
                    if ((FriendPreference.1.this.GZP == null) || (FriendPreference.1.this.GZP.length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    paramAnonymous2Int = FriendPreference.1.this.GZP.lastIndexOf(' ');
                    Object localObject = FriendPreference.1.this.GZP.substring(0, paramAnonymous2Int);
                    if ((localObject == null) || (((String)localObject).length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    ab.c(FriendPreference.c(FriendPreference.this), ((String)localObject).trim());
                    AppMethodBeat.o(27232);
                    return;
                    if ((paramAnonymousView == null) || (paramAnonymousView.length <= 2) || (FriendPreference.a(FriendPreference.this) == null) || (FriendPreference.c(FriendPreference.this) == null))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).lAY)))
                    {
                      FriendPreference.a(FriendPreference.this, FriendPreference.c(FriendPreference.this).field_username, FriendPreference.a(FriendPreference.this).lAY);
                      AppMethodBeat.o(27232);
                      return;
                    }
                    localObject = new Intent();
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("fromScene", 2);
                    ((Intent)localObject).putExtra("reportArgs", localBundle);
                    com.tencent.mm.plugin.profile.b.mIG.i((Intent)localObject, FriendPreference.b(FriendPreference.this));
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
      this.GZJ.setImageBitmap(localBitmap);
    }
    this.GZK.setVisibility(4);
    AppMethodBeat.o(27242);
  }
  
  private void fqv()
  {
    AppMethodBeat.i(27243);
    if ((this.contact == null) || (!this.vkO))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.vkO);
      AppMethodBeat.o(27243);
      return;
    }
    this.fOy = 3;
    this.titleTv.setText(this.mContext.getString(R.l.regby_email_address));
    this.GZI.setText(Util.nullAsNil(this.mTO));
    this.GZJ.setVisibility(8);
    AppMethodBeat.o(27243);
  }
  
  private void init()
  {
    this.vkO = false;
    this.contact = null;
    this.GZL = null;
    this.GZM = "";
    this.GZN = 0L;
    this.GZO = 0L;
    this.fOy = 0;
    this.mTO = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(27239);
    if ((this.contact == null) || (!this.vkO))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.vkO);
      AppMethodBeat.o(27239);
      return;
    }
    if ((this.GZN != -1L) && (new p(this.GZN).longValue() > 0L))
    {
      auN(R.i.ejf);
      fqt();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.GZL != null)
    {
      auN(R.i.ejc);
      fqu();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.GZO > 0L)
    {
      fqs();
      AppMethodBeat.o(27239);
      return;
    }
    if (!TextUtils.isEmpty(this.mTO))
    {
      fqv();
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
      boolean bool = l.a(paramString, this.mContext, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27244);
      return bool;
    }
    AppMethodBeat.o(27244);
    return false;
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(27246);
    long l = d.Tv(paramString);
    if ((l > 0L) && (this.GZN == l) && (d.a(paramString, false, -1, null) != null)) {
      initView();
    }
    if ((d.Tu(paramString) == this.GZO) && (d.a(paramString, false, -1, null) != null)) {
      initView();
    }
    AppMethodBeat.o(27246);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27238);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.GZI = ((TextView)paramView.findViewById(R.h.summary));
    this.GZJ = ((ImageView)paramView.findViewById(R.h.image_iv));
    this.GZK = ((ImageView)paramView.findViewById(R.h.dMC));
    this.vkO = true;
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
    localLayoutInflater.inflate(R.i.eiR, localViewGroup);
    AppMethodBeat.o(27237);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */