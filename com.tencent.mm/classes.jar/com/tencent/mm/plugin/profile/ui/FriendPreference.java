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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
  implements e.a
{
  private TextView BfZ;
  private ImageView Bga;
  private ImageView Bgb;
  private com.tencent.mm.plugin.account.friend.a.a Bgc;
  private String Bgd;
  private long Bge;
  private long Bgf;
  private as contact;
  private int dUW;
  private MMActivity gte;
  private String kcp;
  private boolean rFe;
  private TextView titleTv;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27235);
    this.gte = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27235);
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27236);
    setLayoutResource(2131495538);
    setWidgetLayoutResource(2131495622);
    init();
    AppMethodBeat.o(27236);
  }
  
  private void eEE()
  {
    AppMethodBeat.i(27240);
    if ((this.contact == null) || (!this.rFe))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
      AppMethodBeat.o(27240);
      return;
    }
    this.dUW = 3;
    this.titleTv.setText(this.mContext.getString(2131761545));
    this.BfZ.setText(Util.nullAsNil(this.contact.fuB));
    Object localObject1 = com.tencent.mm.aj.c.LY(this.Bgf);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label365:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(2131690062);
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
          break label365;
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
        this.Bga.setImageBitmap((Bitmap)localObject1);
      }
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.Bga.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690042));
      }
      AppMethodBeat.o(27240);
      return;
    }
  }
  
  private void eEF()
  {
    AppMethodBeat.i(27241);
    if ((this.contact == null) || (!this.rFe))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
      AppMethodBeat.o(27241);
      return;
    }
    this.dUW = 2;
    this.titleTv.setText(this.mContext.getString(2131757912));
    Object localObject1 = Util.nullAsNil(this.Bgd);
    localObject1 = (String)localObject1 + " " + new com.tencent.mm.b.p(this.Bge).longValue();
    this.BfZ.setText((CharSequence)localObject1);
    localObject1 = com.tencent.mm.aj.c.Ah(this.Bge);
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
        localInputStream = this.mContext.getResources().openRawResource(2131690062);
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
        this.Bga.setImageBitmap((Bitmap)localObject1);
      }
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.Bga.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690042));
      }
      AppMethodBeat.o(27241);
      return;
    }
  }
  
  private void eEG()
  {
    AppMethodBeat.i(27242);
    if ((this.contact == null) || (!this.rFe))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
      AppMethodBeat.o(27242);
      return;
    }
    if (this.Bgc == null)
    {
      AppMethodBeat.o(27242);
      return;
    }
    this.dUW = 1;
    this.titleTv.setText(this.mContext.getString(2131757911));
    final String str = Util.nullAsNil(this.Bgc.bnK()) + " " + Util.nullAsNil(this.Bgc.bnP()).replace(" ", "");
    this.BfZ.setText(str);
    Bitmap localBitmap = l.a(this.Bgc.bnJ(), this.mContext);
    if (localBitmap == null) {
      this.Bga.setImageDrawable(com.tencent.mm.cb.a.l(this.gte, 2131690057));
    }
    for (;;)
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.aSN().bjG(this.Bgc.getUsername())) {
        break;
      }
      this.Bgb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(27233);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/FriendPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).iKR))) {}
          for (paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903077);; paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903078))
          {
            h.a(FriendPreference.b(FriendPreference.this), null, paramAnonymousView, null, new h.d()
            {
              public final void oj(int paramAnonymous2Int)
              {
                AppMethodBeat.i(27232);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(27232);
                  return;
                  if ((FriendPreference.1.this.Bgg == null) || (FriendPreference.1.this.Bgg.length() == 0))
                  {
                    AppMethodBeat.o(27232);
                    return;
                  }
                  paramAnonymous2Int = FriendPreference.1.this.Bgg.lastIndexOf(' ') + 1;
                  if (paramAnonymous2Int > 0)
                  {
                    FriendPreference.a(FriendPreference.this, FriendPreference.1.this.Bgg.substring(paramAnonymous2Int));
                    AppMethodBeat.o(27232);
                    return;
                    if ((FriendPreference.1.this.Bgg == null) || (FriendPreference.1.this.Bgg.length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    paramAnonymous2Int = FriendPreference.1.this.Bgg.lastIndexOf(' ');
                    Object localObject = FriendPreference.1.this.Bgg.substring(0, paramAnonymous2Int);
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
                    if ((FriendPreference.a(FriendPreference.this) != null) && (!Util.isNullOrNil(FriendPreference.a(FriendPreference.this).iKR)))
                    {
                      FriendPreference.a(FriendPreference.this, FriendPreference.c(FriendPreference.this).field_username, FriendPreference.a(FriendPreference.this).iKR);
                      AppMethodBeat.o(27232);
                      return;
                    }
                    localObject = new Intent();
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("fromScene", 2);
                    ((Intent)localObject).putExtra("reportArgs", localBundle);
                    com.tencent.mm.plugin.profile.b.jRt.j((Intent)localObject, FriendPreference.b(FriendPreference.this));
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
      this.Bga.setImageBitmap(localBitmap);
    }
    this.Bgb.setVisibility(4);
    AppMethodBeat.o(27242);
  }
  
  private void eEH()
  {
    AppMethodBeat.i(27243);
    if ((this.contact == null) || (!this.rFe))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
      AppMethodBeat.o(27243);
      return;
    }
    this.dUW = 3;
    this.titleTv.setText(this.mContext.getString(2131764343));
    this.BfZ.setText(Util.nullAsNil(this.kcp));
    this.Bga.setVisibility(8);
    AppMethodBeat.o(27243);
  }
  
  private void init()
  {
    this.rFe = false;
    this.contact = null;
    this.Bgc = null;
    this.Bgd = "";
    this.Bge = 0L;
    this.Bgf = 0L;
    this.dUW = 0;
    this.kcp = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(27239);
    if ((this.contact == null) || (!this.rFe))
    {
      Log.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.rFe);
      AppMethodBeat.o(27239);
      return;
    }
    if ((this.Bge != -1L) && (new com.tencent.mm.b.p(this.Bge).longValue() > 0L))
    {
      setWidgetLayoutResource(2131495623);
      eEF();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.Bgc != null)
    {
      setWidgetLayoutResource(2131495610);
      eEG();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.Bgf > 0L)
    {
      eEE();
      AppMethodBeat.o(27239);
      return;
    }
    if (!TextUtils.isEmpty(this.kcp))
    {
      eEH();
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
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(27246);
    long l = com.tencent.mm.aj.c.Ma(paramString);
    if ((l > 0L) && (this.Bge == l) && (com.tencent.mm.aj.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    if ((com.tencent.mm.aj.c.LZ(paramString) == this.Bgf) && (com.tencent.mm.aj.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    AppMethodBeat.o(27246);
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27245);
    com.tencent.mm.aj.p.aYn().e(this);
    AppMethodBeat.o(27245);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27238);
    this.titleTv = ((TextView)paramView.findViewById(2131309195));
    this.BfZ = ((TextView)paramView.findViewById(2131308767));
    this.Bga = ((ImageView)paramView.findViewById(2131302573));
    this.Bgb = ((ImageView)paramView.findViewById(2131304763));
    this.rFe = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27238);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27237);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495562, localViewGroup);
    AppMethodBeat.o(27237);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */