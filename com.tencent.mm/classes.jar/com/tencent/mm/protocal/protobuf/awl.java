package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class awl
  extends cvc
{
  public int GuZ;
  public String app_id;
  public b oAr;
  public int oIt;
  public String oIu;
  public String oIv;
  public String oIw;
  public String oIx;
  public String oxM;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.aS(3, this.oIt);
      if (this.oIu != null) {
        paramVarArgs.d(4, this.oIu);
      }
      if (this.oIv != null) {
        paramVarArgs.d(5, this.oIv);
      }
      paramVarArgs.aS(6, this.time_stamp);
      if (this.oIw != null) {
        paramVarArgs.d(7, this.oIw);
      }
      if (this.oxM != null) {
        paramVarArgs.d(8, this.oxM);
      }
      if (this.oIx != null) {
        paramVarArgs.d(9, this.oIx);
      }
      if (this.oAr != null) {
        paramVarArgs.c(10, this.oAr);
      }
      paramVarArgs.aS(11, this.GuZ);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      i += f.a.a.b.b.a.bz(3, this.oIt);
      paramInt = i;
      if (this.oIu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oIu);
      }
      i = paramInt;
      if (this.oIv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oIv);
      }
      i += f.a.a.b.b.a.bz(6, this.time_stamp);
      paramInt = i;
      if (this.oIw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.oIw);
      }
      i = paramInt;
      if (this.oxM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oxM);
      }
      paramInt = i;
      if (this.oIx != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oIx);
      }
      i = paramInt;
      if (this.oAr != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.oAr);
      }
      paramInt = f.a.a.b.b.a.bz(11, this.GuZ);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awl localawl = (awl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
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
            localawl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localawl.app_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localawl.oIt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localawl.oIu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localawl.oIv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localawl.time_stamp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localawl.oIw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localawl.oxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localawl.oIx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localawl.oAr = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(114000);
          return 0;
        }
        localawl.GuZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awl
 * JD-Core Version:    0.7.0.1
 */