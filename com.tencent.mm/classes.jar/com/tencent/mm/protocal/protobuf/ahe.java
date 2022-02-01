package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahe
  extends com.tencent.mm.bx.a
{
  public LinkedList<ahf> CMg;
  public String CUC;
  public String Djm;
  public long Djn;
  public long Djo;
  public String Djp;
  public long Djq;
  public String vzN;
  
  public ahe()
  {
    AppMethodBeat.i(91458);
    this.CMg = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Djm != null) {
        paramVarArgs.d(1, this.Djm);
      }
      paramVarArgs.e(2, 8, this.CMg);
      paramVarArgs.aG(3, this.Djn);
      paramVarArgs.aG(4, this.Djo);
      if (this.Djp != null) {
        paramVarArgs.d(5, this.Djp);
      }
      if (this.vzN != null) {
        paramVarArgs.d(6, this.vzN);
      }
      paramVarArgs.aG(7, this.Djq);
      if (this.CUC != null) {
        paramVarArgs.d(8, this.CUC);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Djm == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.Djm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.CMg) + f.a.a.b.b.a.q(3, this.Djn) + f.a.a.b.b.a.q(4, this.Djo);
      paramInt = i;
      if (this.Djp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Djp);
      }
      i = paramInt;
      if (this.vzN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vzN);
      }
      i += f.a.a.b.b.a.q(7, this.Djq);
      paramInt = i;
      if (this.CUC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CUC);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CMg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahe localahe = (ahe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localahe.Djm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahe.CMg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localahe.Djn = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localahe.Djo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localahe.Djp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localahe.vzN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localahe.Djq = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91459);
          return 0;
        }
        localahe.CUC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahe
 * JD-Core Version:    0.7.0.1
 */