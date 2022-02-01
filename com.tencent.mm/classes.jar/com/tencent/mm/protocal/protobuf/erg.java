package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class erg
  extends com.tencent.mm.cd.a
{
  public fmk StQ;
  public long Utt;
  public long Utu;
  public long Utv;
  public long Utw;
  public LinkedList<b> Utx;
  public long begin_time;
  public long duration;
  public String text;
  
  public erg()
  {
    AppMethodBeat.i(110911);
    this.Utx = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.StQ != null)
      {
        paramVarArgs.oE(1, this.StQ.computeSize());
        this.StQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.begin_time);
      paramVarArgs.bm(3, this.duration);
      if (this.text != null) {
        paramVarArgs.f(4, this.text);
      }
      paramVarArgs.bm(5, this.Utt);
      paramVarArgs.bm(6, this.Utu);
      paramVarArgs.bm(7, this.Utv);
      paramVarArgs.bm(8, this.Utw);
      paramVarArgs.e(9, 6, this.Utx);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.StQ == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = g.a.a.a.oD(1, this.StQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.begin_time) + g.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.text);
      }
      i = g.a.a.b.b.a.p(5, this.Utt);
      int j = g.a.a.b.b.a.p(6, this.Utu);
      int k = g.a.a.b.b.a.p(7, this.Utv);
      int m = g.a.a.b.b.a.p(8, this.Utw);
      int n = g.a.a.a.c(9, 6, this.Utx);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Utx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        erg localerg = (erg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fmk localfmk = new fmk();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmk.parseFrom((byte[])localObject);
            }
            localerg.StQ = localfmk;
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localerg.begin_time = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localerg.duration = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localerg.text = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localerg.Utt = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localerg.Utu = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localerg.Utv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localerg.Utw = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110912);
          return 0;
        }
        localerg.Utx.add(((g.a.a.a.a)localObject).abFh.iUw());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erg
 * JD-Core Version:    0.7.0.1
 */