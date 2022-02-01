package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pl
  extends cvc
{
  public String FGE;
  public bvr FKE;
  public cxf FKF;
  public int FqH;
  public String FqI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FGE != null) {
        paramVarArgs.d(2, this.FGE);
      }
      if (this.FKE != null)
      {
        paramVarArgs.lC(3, this.FKE.computeSize());
        this.FKE.writeFields(paramVarArgs);
      }
      if (this.FKF != null)
      {
        paramVarArgs.lC(4, this.FKF.computeSize());
        this.FKF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FqH);
      if (this.FqI != null) {
        paramVarArgs.d(6, this.FqI);
      }
      AppMethodBeat.o(32149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FGE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FGE);
      }
      i = paramInt;
      if (this.FKE != null) {
        i = paramInt + f.a.a.a.lB(3, this.FKE.computeSize());
      }
      paramInt = i;
      if (this.FKF != null) {
        paramInt = i + f.a.a.a.lB(4, this.FKF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FqH);
      paramInt = i;
      if (this.FqI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FqI);
      }
      AppMethodBeat.o(32149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pl localpl = (pl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32149);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 2: 
          localpl.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32149);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.FKE = ((bvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.FKF = ((cxf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 5: 
          localpl.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32149);
          return 0;
        }
        localpl.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32149);
        return 0;
      }
      AppMethodBeat.o(32149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */