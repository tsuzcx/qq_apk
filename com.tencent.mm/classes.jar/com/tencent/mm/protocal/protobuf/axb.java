package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class axb
  extends cvw
{
  public int GOy;
  public String app_id;
  public String oEo;
  public b oGT;
  public int oOV;
  public String oOW;
  public String oOX;
  public String oOY;
  public String oOZ;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.aS(3, this.oOV);
      if (this.oOW != null) {
        paramVarArgs.d(4, this.oOW);
      }
      if (this.oOX != null) {
        paramVarArgs.d(5, this.oOX);
      }
      paramVarArgs.aS(6, this.time_stamp);
      if (this.oOY != null) {
        paramVarArgs.d(7, this.oOY);
      }
      if (this.oEo != null) {
        paramVarArgs.d(8, this.oEo);
      }
      if (this.oOZ != null) {
        paramVarArgs.d(9, this.oOZ);
      }
      if (this.oGT != null) {
        paramVarArgs.c(10, this.oGT);
      }
      paramVarArgs.aS(11, this.GOy);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      i += f.a.a.b.b.a.bz(3, this.oOV);
      paramInt = i;
      if (this.oOW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oOW);
      }
      i = paramInt;
      if (this.oOX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oOX);
      }
      i += f.a.a.b.b.a.bz(6, this.time_stamp);
      paramInt = i;
      if (this.oOY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.oOY);
      }
      i = paramInt;
      if (this.oEo != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oEo);
      }
      paramInt = i;
      if (this.oOZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oOZ);
      }
      i = paramInt;
      if (this.oGT != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.oGT);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GOy);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axb localaxb = (axb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localaxb.app_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localaxb.oOV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localaxb.oOW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localaxb.oOX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localaxb.time_stamp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localaxb.oOY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localaxb.oEo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localaxb.oOZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localaxb.oGT = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(114000);
          return 0;
        }
        localaxb.GOy = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axb
 * JD-Core Version:    0.7.0.1
 */