package com.tencent.mm.wear.app.ui.emoji;

import android.content.Context;
import android.support.wearable.view.x;
import com.tencent.mm.e.a.f;
import com.tencent.mm.e.a.g;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends x
{
  private String aiU;
  private List<String> aiV;
  private c aiW;
  private Context context;
  
  public b(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.aiU = paramString;
    this.aiV = new ArrayList();
  }
  
  public final void a(c paramc)
  {
    this.aiW = paramc;
  }
  
  public final int getItemCount()
  {
    return this.aiV.size();
  }
  
  public final void nY()
  {
    Object localObject = new f();
    ((f)localObject).Xo = this.aiU;
    try
    {
      localObject = new com.tencent.mm.wear.app.f.b(11004, ((f)localObject).toByteArray());
      ((com.tencent.mm.wear.app.f.b)localObject).a(new d()
      {
        public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
        {
          g localg;
          if (paramAnonymousInt2 == 0) {
            localg = new g();
          }
          try
          {
            localg.h(paramAnonymousArrayOfByte);
            label20:
            b.a(b.this).addAll(localg.Xp);
            paramAnonymousArrayOfByte = b.this;
            com.tencent.mm.wear.a.b.a.amv.post(new b.2(paramAnonymousArrayOfByte));
            return;
          }
          catch (IOException paramAnonymousArrayOfByte)
          {
            break label20;
          }
        }
      });
      h.mP().a((com.tencent.mm.wear.app.g.a)localObject);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.b
 * JD-Core Version:    0.7.0.1
 */