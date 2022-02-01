package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amz
  extends cvc
{
  public String GlV;
  public alk Glv;
  public int opType;
  public String rTn;
  public long refObjectId;
  public String refObjectNonceId;
  public String sessionBuffer;
  public int vug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GlV != null) {
        paramVarArgs.d(2, this.GlV);
      }
      paramVarArgs.aS(3, this.opType);
      paramVarArgs.aY(4, this.refObjectId);
      if (this.rTn != null) {
        paramVarArgs.d(5, this.rTn);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(7, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      paramVarArgs.aS(9, this.vug);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GlV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GlV);
      }
      i = i + f.a.a.b.b.a.bz(3, this.opType) + f.a.a.b.b.a.p(4, this.refObjectId);
      paramInt = i;
      if (this.rTn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.rTn);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(7, this.Glv.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.vug);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amz localamz = (amz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
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
            localamz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localamz.GlV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localamz.opType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localamz.refObjectId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localamz.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localamz.refObjectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamz.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localamz.sessionBuffer = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localamz.vug = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amz
 * JD-Core Version:    0.7.0.1
 */