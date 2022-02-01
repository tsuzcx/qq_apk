package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asn
  extends cpx
{
  public int ELV;
  public String app_id;
  public String nUr;
  public b nWX;
  public int oeZ;
  public String ofa;
  public String ofb;
  public String ofc;
  public String ofd;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.aR(3, this.oeZ);
      if (this.ofa != null) {
        paramVarArgs.d(4, this.ofa);
      }
      if (this.ofb != null) {
        paramVarArgs.d(5, this.ofb);
      }
      paramVarArgs.aR(6, this.time_stamp);
      if (this.ofc != null) {
        paramVarArgs.d(7, this.ofc);
      }
      if (this.nUr != null) {
        paramVarArgs.d(8, this.nUr);
      }
      if (this.ofd != null) {
        paramVarArgs.d(9, this.ofd);
      }
      if (this.nWX != null) {
        paramVarArgs.c(10, this.nWX);
      }
      paramVarArgs.aR(11, this.ELV);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      i += f.a.a.b.b.a.bx(3, this.oeZ);
      paramInt = i;
      if (this.ofa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ofa);
      }
      i = paramInt;
      if (this.ofb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ofb);
      }
      i += f.a.a.b.b.a.bx(6, this.time_stamp);
      paramInt = i;
      if (this.ofc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ofc);
      }
      i = paramInt;
      if (this.nUr != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.nUr);
      }
      paramInt = i;
      if (this.ofd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ofd);
      }
      i = paramInt;
      if (this.nWX != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.nWX);
      }
      paramInt = f.a.a.b.b.a.bx(11, this.ELV);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asn localasn = (asn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localasn.app_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localasn.oeZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localasn.ofa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localasn.ofb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localasn.time_stamp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localasn.ofc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localasn.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localasn.ofd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localasn.nWX = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(114000);
          return 0;
        }
        localasn.ELV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asn
 * JD-Core Version:    0.7.0.1
 */