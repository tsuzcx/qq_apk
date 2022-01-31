package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import junit.framework.Assert;

public class FriendPreference
  extends Preference
  implements d.a
{
  private MMActivity bER;
  private int bUB;
  private ad dnp;
  private TextView eXr;
  private String fds;
  private boolean jAt;
  private TextView mXQ;
  private ImageView mXR;
  private ImageView mXS;
  private com.tencent.mm.plugin.account.friend.a.a mXT;
  private String mXU;
  private long mXV;
  private long mXW;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
    init();
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
    setWidgetLayoutResource(R.i.mm_preference_submenu);
    init();
  }
  
  private void init()
  {
    this.jAt = false;
    this.dnp = null;
    this.mXT = null;
    this.mXU = "";
    this.mXV = 0L;
    this.mXW = 0L;
    this.bUB = 0;
    this.fds = "";
  }
  
  private void initView()
  {
    if ((this.dnp == null) || (!this.jAt))
    {
      y.d("MicroMsg.FriendPreference", "initView : contact = " + this.dnp + " bindView = " + this.jAt);
      return;
    }
    Object localObject1;
    Object localObject9;
    Object localObject7;
    if ((this.mXV != -1L) && (new com.tencent.mm.a.o(this.mXV).longValue() > 0L))
    {
      setWidgetLayoutResource(R.i.mm_preference_submenu_qzone);
      if ((this.dnp == null) || (!this.jAt))
      {
        y.d("MicroMsg.FriendPreference", "initView : contact = " + this.dnp + " bindView = " + this.jAt);
        return;
      }
      this.bUB = 2;
      this.eXr.setText(this.mContext.getString(R.l.contact_info_friendtype_qq));
      localObject1 = bk.pm(this.mXU);
      localObject1 = (String)localObject1 + " " + new com.tencent.mm.a.o(this.mXV).longValue();
      this.mXQ.setText((CharSequence)localObject1);
      localObject1 = b.bG(this.mXV);
      if (localObject1 != null) {
        break label1134;
      }
      localObject9 = null;
      localObject7 = null;
    }
    label412:
    label1001:
    label1131:
    label1134:
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        localInputStream1 = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
        localObject7 = localInputStream1;
        localObject9 = localInputStream1;
        localBitmap = com.tencent.mm.compatible.g.a.decodeStream(localInputStream1);
        localObject7 = localBitmap;
        localObject1 = localObject7;
      }
      catch (Exception localException7)
      {
        InputStream localInputStream1;
        localObject9 = localObject7;
        y.printErrStackTrace("MicroMsg.FriendPreference", localException7, "", new Object[0]);
        if (localObject7 == null) {
          break label1134;
        }
        try
        {
          ((InputStream)localObject7).close();
        }
        catch (Exception localException3)
        {
          y.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject9 == null) {
          break label412;
        }
      }
      try
      {
        localInputStream1.close();
        localObject1 = localObject7;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject7;
        continue;
      }
      if (localObject1 != null)
      {
        localObject7 = Bitmap.createScaledBitmap((Bitmap)localObject1, 48, 48, false);
        if (localObject7 != localObject1) {
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject7, true, 0.0F);
        this.mXR.setImageBitmap((Bitmap)localObject1);
      }
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        break;
      }
      this.mXR.setBackgroundDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.default_avatar));
      return;
      try
      {
        Object localObject2;
        localObject9.close();
        throw localObject3;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        }
      }
      Object localObject4;
      Object localObject8;
      if (this.mXT != null)
      {
        setWidgetLayoutResource(R.i.mm_preference_more);
        if ((this.dnp == null) || (!this.jAt))
        {
          y.d("MicroMsg.FriendPreference", "initView : contact = " + this.dnp + " bindView = " + this.jAt);
          return;
        }
        if (this.mXT == null) {
          break;
        }
        this.bUB = 1;
        this.eXr.setText(this.mContext.getString(R.l.contact_info_friendtype_mobile));
        localObject4 = bk.pm(this.mXT.Wx()) + " " + bk.pm(this.mXT.WD()).replace(" ", "");
        this.mXQ.setText((CharSequence)localObject4);
        localObject8 = l.b(this.mXT.Ww(), this.mContext);
        if (localObject8 == null) {
          this.mXR.setImageDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.default_mobile_avatar));
        }
        for (;;)
        {
          au.Hx();
          if (!com.tencent.mm.model.c.Fw().abg(this.mXT.getUsername())) {
            break;
          }
          this.mXS.setOnClickListener(new FriendPreference.1(this, (String)localObject4));
          return;
          localObject8 = com.tencent.mm.sdk.platformtools.c.a(Bitmap.createScaledBitmap((Bitmap)localObject8, 48, 48, false), true, 0.0F);
          this.mXR.setImageBitmap((Bitmap)localObject8);
        }
        this.mXS.setVisibility(4);
        return;
      }
      if (this.mXW > 0L)
      {
        if ((this.dnp == null) || (!this.jAt))
        {
          y.d("MicroMsg.FriendPreference", "initView : contact = " + this.dnp + " bindView = " + this.jAt);
          return;
        }
        this.bUB = 3;
        this.eXr.setText(this.mContext.getString(R.l.hardcode_plugin_facebookapp_nick));
        this.mXQ.setText(bk.pm(this.dnp.cCr));
        localObject4 = b.jU(this.mXW);
        if (localObject4 != null) {
          break label1131;
        }
        localObject9 = null;
        localObject8 = null;
      }
      for (;;)
      {
        try
        {
          localInputStream2 = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
          localObject8 = localInputStream2;
          localObject9 = localInputStream2;
          localBitmap = com.tencent.mm.compatible.g.a.decodeStream(localInputStream2);
          localObject8 = localBitmap;
          localObject4 = localObject8;
        }
        catch (Exception localException8)
        {
          InputStream localInputStream2;
          localObject9 = localObject8;
          y.printErrStackTrace("MicroMsg.FriendPreference", localException8, "", new Object[0]);
          if (localObject8 == null) {
            break label1131;
          }
          try
          {
            ((InputStream)localObject8).close();
          }
          catch (Exception localException5)
          {
            y.printErrStackTrace("MicroMsg.FriendPreference", localException5, "", new Object[0]);
          }
          continue;
        }
        finally
        {
          if (localObject9 == null) {
            break label1001;
          }
        }
        try
        {
          localInputStream2.close();
          localObject4 = localObject8;
        }
        catch (Exception localException2)
        {
          y.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
          localObject5 = localObject8;
          continue;
        }
        if (localObject4 != null)
        {
          localObject8 = Bitmap.createScaledBitmap((Bitmap)localObject4, 48, 48, false);
          if (localObject8 != localObject4) {
            ((Bitmap)localObject4).recycle();
          }
          localObject4 = com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject8, true, 0.0F);
          this.mXR.setImageBitmap((Bitmap)localObject4);
        }
        au.Hx();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          break;
        }
        this.mXR.setBackgroundDrawable(com.tencent.mm.cb.a.g(this.bER, R.k.default_avatar));
        return;
        try
        {
          Object localObject5;
          localObject9.close();
          throw localObject6;
        }
        catch (Exception localException6)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.FriendPreference", localException6, "", new Object[0]);
          }
        }
        if (!TextUtils.isEmpty(this.fds))
        {
          if ((this.dnp == null) || (!this.jAt))
          {
            y.d("MicroMsg.FriendPreference", "initView : contact = " + this.dnp + " bindView = " + this.jAt);
            return;
          }
          this.bUB = 3;
          this.eXr.setText(this.mContext.getString(R.l.regby_email_address));
          this.mXQ.setText(bk.pm(this.fds));
          this.mXR.setVisibility(8);
          return;
        }
        Assert.assertTrue(false);
        return;
      }
    }
  }
  
  private boolean o(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      return l.a(paramString, this.mContext, localByteArrayOutputStream.toByteArray());
    }
    return false;
  }
  
  public final boolean awZ()
  {
    com.tencent.mm.ag.o.JQ().e(this);
    return true;
  }
  
  public final void kk(String paramString)
  {
    long l = b.jW(paramString);
    if ((l > 0L) && (this.mXV == l) && (b.a(paramString, false, -1) != null)) {
      initView();
    }
    if ((b.jV(paramString) == this.mXW) && (b.a(paramString, false, -1) != null)) {
      initView();
    }
  }
  
  public final void onBindView(View paramView)
  {
    this.eXr = ((TextView)paramView.findViewById(R.h.title));
    this.mXQ = ((TextView)paramView.findViewById(R.h.summary));
    this.mXR = ((ImageView)paramView.findViewById(R.h.image_iv));
    this.mXS = ((ImageView)paramView.findViewById(R.h.mobile_preference_more));
    this.jAt = true;
    initView();
    super.onBindView(paramView);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_friend, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */