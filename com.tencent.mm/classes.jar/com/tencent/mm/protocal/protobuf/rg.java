package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rg
  extends com.tencent.mm.bx.a
{
  public String CRj;
  public String CRk;
  public String CRl;
  public int CRm;
  public String CRn;
  public rc CRo;
  public String CRp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CRj != null) {
        paramVarArgs.d(1, this.CRj);
      }
      if (this.CRk != null) {
        paramVarArgs.d(2, this.CRk);
      }
      if (this.CRl != null) {
        paramVarArgs.d(3, this.CRl);
      }
      paramVarArgs.aR(4, this.CRm);
      if (this.CRn != null) {
        paramVarArgs.d(5, this.CRn);
      }
      if (this.CRo != null)
      {
        paramVarArgs.kX(6, this.CRo.computeSize());
        this.CRo.writeFields(paramVarArgs);
      }
      if (this.CRp != null) {
        paramVarArgs.d(7, this.CRp);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRj == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.CRj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CRk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CRk);
      }
      i = paramInt;
      if (this.CRl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CRl);
      }
      i += f.a.a.b.b.a.bA(4, this.CRm);
      paramInt = i;
      if (this.CRn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CRn);
      }
      i = paramInt;
      if (this.CRo != null) {
        i = paramInt + f.a.a.a.kW(6, this.CRo.computeSize());
      }
      paramInt = i;
      if (this.CRp != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CRp);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rg localrg = (rg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localrg.CRj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localrg.CRk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localrg.CRl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localrg.CRm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localrg.CRn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrg.CRo = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localrg.CRp = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */