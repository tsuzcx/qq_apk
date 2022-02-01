package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpx
  extends cvp
{
  public String Fxq;
  public int GGs;
  public String HDX;
  public String HDY;
  public ddy HDZ;
  public String HEa;
  public com.tencent.mm.bx.b HEb;
  public String HcJ;
  public String Hkh;
  public int dqI;
  public String dqJ;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dqI);
      if (this.dqJ != null) {
        paramVarArgs.d(3, this.dqJ);
      }
      if (this.HDX != null) {
        paramVarArgs.d(4, this.HDX);
      }
      if (this.HDY != null) {
        paramVarArgs.d(5, this.HDY);
      }
      if (this.HDZ != null)
      {
        paramVarArgs.lC(6, this.HDZ.computeSize());
        this.HDZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.version);
      if (this.HEa != null) {
        paramVarArgs.d(8, this.HEa);
      }
      paramVarArgs.aS(9, this.GGs);
      if (this.HcJ != null) {
        paramVarArgs.d(10, this.HcJ);
      }
      if (this.Hkh != null) {
        paramVarArgs.d(11, this.Hkh);
      }
      if (this.Fxq != null) {
        paramVarArgs.d(12, this.Fxq);
      }
      if (this.HEb != null) {
        paramVarArgs.c(13, this.HEb);
      }
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dqI);
      paramInt = i;
      if (this.dqJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dqJ);
      }
      i = paramInt;
      if (this.HDX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HDX);
      }
      paramInt = i;
      if (this.HDY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HDY);
      }
      i = paramInt;
      if (this.HDZ != null) {
        i = paramInt + f.a.a.a.lB(6, this.HDZ.computeSize());
      }
      i += f.a.a.b.b.a.bz(7, this.version);
      paramInt = i;
      if (this.HEa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HEa);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GGs);
      paramInt = i;
      if (this.HcJ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HcJ);
      }
      i = paramInt;
      if (this.Hkh != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Hkh);
      }
      paramInt = i;
      if (this.Fxq != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fxq);
      }
      i = paramInt;
      if (this.HEb != null) {
        i = paramInt + f.a.a.b.b.a.b(13, this.HEb);
      }
      AppMethodBeat.o(152714);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpx localdpx = (dpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localdpx.dqI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localdpx.dqJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localdpx.HDX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localdpx.HDY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpx.HDZ = ((ddy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 7: 
          localdpx.version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 8: 
          localdpx.HEa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 9: 
          localdpx.GGs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152714);
          return 0;
        case 10: 
          localdpx.HcJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 11: 
          localdpx.Hkh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 12: 
          localdpx.Fxq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152714);
          return 0;
        }
        localdpx.HEb = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpx
 * JD-Core Version:    0.7.0.1
 */