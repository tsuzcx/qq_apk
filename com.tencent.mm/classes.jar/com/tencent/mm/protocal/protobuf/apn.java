package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apn
  extends ckq
{
  public String Ctm;
  public int Ctn;
  public dt DqZ;
  public String appId;
  public String cMo;
  public String riA;
  public String riy;
  public String riz;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      if (this.riy != null) {
        paramVarArgs.d(3, this.riy);
      }
      if (this.riz != null) {
        paramVarArgs.d(4, this.riz);
      }
      if (this.riA != null) {
        paramVarArgs.d(5, this.riA);
      }
      if (this.cMo != null) {
        paramVarArgs.d(6, this.cMo);
      }
      if (this.sign != null) {
        paramVarArgs.d(7, this.sign);
      }
      if (this.DqZ != null)
      {
        paramVarArgs.kX(8, this.DqZ.computeSize());
        this.DqZ.writeFields(paramVarArgs);
      }
      if (this.Ctm != null) {
        paramVarArgs.d(9, this.Ctm);
      }
      paramVarArgs.aR(10, this.Ctn);
      AppMethodBeat.o(32219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.appId);
      }
      i = paramInt;
      if (this.riy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.riy);
      }
      paramInt = i;
      if (this.riz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.riz);
      }
      i = paramInt;
      if (this.riA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.riA);
      }
      paramInt = i;
      if (this.cMo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cMo);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sign);
      }
      paramInt = i;
      if (this.DqZ != null) {
        paramInt = i + f.a.a.a.kW(8, this.DqZ.computeSize());
      }
      i = paramInt;
      if (this.Ctm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ctm);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Ctn);
      AppMethodBeat.o(32219);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apn localapn = (apn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32219);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 2: 
          localapn.appId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 3: 
          localapn.riy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 4: 
          localapn.riz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 5: 
          localapn.riA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 6: 
          localapn.cMo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 7: 
          localapn.sign = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapn.DqZ = ((dt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 9: 
          localapn.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32219);
          return 0;
        }
        localapn.Ctn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32219);
        return 0;
      }
      AppMethodBeat.o(32219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apn
 * JD-Core Version:    0.7.0.1
 */