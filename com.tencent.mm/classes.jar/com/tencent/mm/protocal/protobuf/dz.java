package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dz
  extends cvc
{
  public String FpH;
  public String FvZ;
  public int Fwa;
  public String duW;
  public String dvs;
  public String oIw;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.FpH != null) {
        paramVarArgs.d(3, this.FpH);
      }
      if (this.oIw != null) {
        paramVarArgs.d(4, this.oIw);
      }
      if (this.signature != null) {
        paramVarArgs.d(5, this.signature);
      }
      if (this.dvs != null) {
        paramVarArgs.d(6, this.dvs);
      }
      if (this.FvZ != null) {
        paramVarArgs.d(7, this.FvZ);
      }
      paramVarArgs.aS(8, this.Fwa);
      AppMethodBeat.o(219252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.FpH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FpH);
      }
      paramInt = i;
      if (this.oIw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oIw);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.signature);
      }
      paramInt = i;
      if (this.dvs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dvs);
      }
      i = paramInt;
      if (this.FvZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FvZ);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Fwa);
      AppMethodBeat.o(219252);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dz localdz = (dz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(219252);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(219252);
          return 0;
        case 2: 
          localdz.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        case 3: 
          localdz.FpH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        case 4: 
          localdz.oIw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        case 5: 
          localdz.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        case 6: 
          localdz.dvs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        case 7: 
          localdz.FvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(219252);
          return 0;
        }
        localdz.Fwa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(219252);
        return 0;
      }
      AppMethodBeat.o(219252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */