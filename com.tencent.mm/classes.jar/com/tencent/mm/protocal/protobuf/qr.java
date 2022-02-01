package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qr
  extends com.tencent.mm.bx.a
{
  public String CQj;
  public String CQk;
  public String CQl;
  public int CQm;
  public rc CQn;
  public int CQo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CQj != null) {
        paramVarArgs.d(1, this.CQj);
      }
      if (this.CQk != null) {
        paramVarArgs.d(2, this.CQk);
      }
      if (this.CQl != null) {
        paramVarArgs.d(3, this.CQl);
      }
      paramVarArgs.aR(4, this.CQm);
      if (this.CQn != null)
      {
        paramVarArgs.kX(5, this.CQn.computeSize());
        this.CQn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.CQo);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQj == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.CQj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CQk);
      }
      i = paramInt;
      if (this.CQl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CQl);
      }
      i += f.a.a.b.b.a.bA(4, this.CQm);
      paramInt = i;
      if (this.CQn != null) {
        paramInt = i + f.a.a.a.kW(5, this.CQn.computeSize());
      }
      i = f.a.a.b.b.a.bA(6, this.CQo);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qr localqr = (qr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localqr.CQj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localqr.CQk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localqr.CQl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localqr.CQm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqr.CQn = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localqr.CQo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qr
 * JD-Core Version:    0.7.0.1
 */