package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mr
  extends com.tencent.mm.bw.a
{
  public String EbB;
  public LinkedList<ms> EbC;
  public int EbD;
  public String Ebm;
  public int Ebn;
  public String Ebq;
  public String Ebt;
  public String nYC;
  public int ver;
  
  public mr()
  {
    AppMethodBeat.i(209563);
    this.EbC = new LinkedList();
    AppMethodBeat.o(209563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebt != null) {
        paramVarArgs.d(1, this.Ebt);
      }
      if (this.nYC != null) {
        paramVarArgs.d(2, this.nYC);
      }
      paramVarArgs.aR(3, this.ver);
      if (this.Ebm != null) {
        paramVarArgs.d(4, this.Ebm);
      }
      if (this.EbB != null) {
        paramVarArgs.d(5, this.EbB);
      }
      paramVarArgs.aR(6, this.Ebn);
      if (this.Ebq != null) {
        paramVarArgs.d(7, this.Ebq);
      }
      paramVarArgs.e(8, 8, this.EbC);
      paramVarArgs.aR(9, this.EbD);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebt == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ebt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nYC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nYC);
      }
      i += f.a.a.b.b.a.bx(3, this.ver);
      paramInt = i;
      if (this.Ebm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ebm);
      }
      i = paramInt;
      if (this.EbB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EbB);
      }
      i += f.a.a.b.b.a.bx(6, this.Ebn);
      paramInt = i;
      if (this.Ebq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ebq);
      }
      i = f.a.a.a.c(8, 8, this.EbC);
      int j = f.a.a.b.b.a.bx(9, this.EbD);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EbC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mr localmr = (mr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localmr.Ebt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localmr.nYC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localmr.ver = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localmr.Ebm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localmr.EbB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localmr.Ebn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localmr.Ebq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ms();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ms)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmr.EbC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localmr.EbD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mr
 * JD-Core Version:    0.7.0.1
 */