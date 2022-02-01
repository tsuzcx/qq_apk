package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class us
  extends com.tencent.mm.cd.a
{
  public String GGC;
  public erh RGf;
  public eaa RGh;
  public String ROQ;
  public clc Sfq;
  public LinkedList<erh> Sfr;
  public int Sfs;
  public int Sft;
  public String fvP;
  public int state;
  
  public us()
  {
    AppMethodBeat.i(91394);
    this.Sfr = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sfq != null)
      {
        paramVarArgs.oE(1, this.Sfq.computeSize());
        this.Sfq.writeFields(paramVarArgs);
      }
      if (this.RGf != null)
      {
        paramVarArgs.oE(2, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Sfr);
      if (this.GGC != null) {
        paramVarArgs.f(4, this.GGC);
      }
      if (this.fvP != null) {
        paramVarArgs.f(5, this.fvP);
      }
      if (this.RGh != null)
      {
        paramVarArgs.oE(6, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.state);
      paramVarArgs.aY(8, this.Sfs);
      paramVarArgs.aY(9, this.Sft);
      if (this.ROQ != null) {
        paramVarArgs.f(10, this.ROQ);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sfq == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = g.a.a.a.oD(1, this.Sfq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RGf != null) {
        i = paramInt + g.a.a.a.oD(2, this.RGf.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.Sfr);
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GGC);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fvP);
      }
      paramInt = i;
      if (this.RGh != null) {
        paramInt = i + g.a.a.a.oD(6, this.RGh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.state) + g.a.a.b.b.a.bM(8, this.Sfs) + g.a.a.b.b.a.bM(9, this.Sft);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ROQ);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sfr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        us localus = (us)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clc)localObject2).parseFrom((byte[])localObject1);
            }
            localus.Sfq = ((clc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localus.RGf = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localus.Sfr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localus.GGC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localus.fvP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaa)localObject2).parseFrom((byte[])localObject1);
            }
            localus.RGh = ((eaa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localus.state = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localus.Sfs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localus.Sft = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91395);
          return 0;
        }
        localus.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.us
 * JD-Core Version:    0.7.0.1
 */