package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

abstract class bb$f
{
  View.OnClickListener yQK = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99033);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99033);
        return;
      }
      ac.d("MicroMsg.SnsphotoAdapter", "sign click");
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hz(i, j + 2);
      AppMethodBeat.o(99033);
    }
  };
  View.OnClickListener yQL = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99034);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99034);
        return;
      }
      ac.d("MicroMsg.SnsphotoAdapter", "sign click");
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      bb.f.this.PD(i);
      AppMethodBeat.o(99034);
    }
  };
  View.OnClickListener yQM = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99035);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99035);
        return;
      }
      ac.d("MicroMsg.SnsphotoAdapter", "snssight click");
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hz(i, j + 2);
      AppMethodBeat.o(99035);
    }
  };
  View.OnLongClickListener yQN = new View.OnLongClickListener()
  {
    public final boolean onLongClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99036);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99036);
        return true;
      }
      ac.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hA(i, j);
      AppMethodBeat.o(99036);
      return true;
    }
  };
  public bb.f.a yQO = new bb.f.a();
  View.OnClickListener ywP = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99030);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99030);
        return;
      }
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hy(i, j);
      AppMethodBeat.o(99030);
    }
  };
  View.OnClickListener ywQ = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99031);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99031);
        return;
      }
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hy(i, j + 1);
      AppMethodBeat.o(99031);
    }
  };
  View.OnClickListener ywR = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(99032);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(99032);
        return;
      }
      bb.f.this.yQO = ((bb.f.a)paramAnonymousView.getTag());
      int i = bb.f.this.yQO.dwR;
      int j = bb.f.this.yQO.position;
      bb.f.this.hy(i, j + 2);
      AppMethodBeat.o(99032);
    }
  };
  
  public abstract void PD(int paramInt);
  
  public abstract void hA(int paramInt1, int paramInt2);
  
  public abstract void hy(int paramInt1, int paramInt2);
  
  public abstract void hz(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb.f
 * JD-Core Version:    0.7.0.1
 */