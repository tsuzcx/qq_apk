package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkl
  extends dop
{
  public String KDf;
  public String KDg;
  public int KDh;
  public LinkedList<um> KDk;
  public String LTz;
  public int eaQ;
  public String qGX;
  public String qGp;
  public String sign;
  
  public bkl()
  {
    AppMethodBeat.i(114012);
    this.KDk = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KDk);
      paramVarArgs.aM(3, this.eaQ);
      if (this.qGX != null) {
        paramVarArgs.e(4, this.qGX);
      }
      if (this.qGp != null) {
        paramVarArgs.e(5, this.qGp);
      }
      if (this.sign != null) {
        paramVarArgs.e(6, this.sign);
      }
      if (this.KDf != null) {
        paramVarArgs.e(7, this.KDf);
      }
      if (this.KDg != null) {
        paramVarArgs.e(8, this.KDg);
      }
      if (this.LTz != null) {
        paramVarArgs.e(9, this.LTz);
      }
      paramVarArgs.aM(10, this.KDh);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KDk) + g.a.a.b.b.a.bu(3, this.eaQ);
      paramInt = i;
      if (this.qGX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qGX);
      }
      i = paramInt;
      if (this.qGp != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qGp);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.sign);
      }
      i = paramInt;
      if (this.KDf != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KDf);
      }
      paramInt = i;
      if (this.KDg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KDg);
      }
      i = paramInt;
      if (this.LTz != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LTz);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KDh);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KDk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkl localbkl = (bkl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new um();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((um)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkl.KDk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localbkl.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localbkl.qGX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localbkl.qGp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localbkl.sign = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localbkl.KDf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localbkl.KDg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localbkl.LTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localbkl.KDh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkl
 * JD-Core Version:    0.7.0.1
 */