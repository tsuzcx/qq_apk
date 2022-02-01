package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bhy
  extends dop
{
  public String GaP;
  public int LSk;
  public int LSl;
  public String LSm;
  public String LSn;
  public int count;
  public String dNI;
  public String desc;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.GaP == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LSk);
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      paramVarArgs.aM(5, this.LSl);
      if (this.LSm != null) {
        paramVarArgs.e(6, this.LSm);
      }
      paramVarArgs.aM(7, this.count);
      paramVarArgs.aM(8, this.scene);
      if (this.GaP != null) {
        paramVarArgs.e(9, this.GaP);
      }
      if (this.sign != null) {
        paramVarArgs.e(10, this.sign);
      }
      if (this.LSn != null) {
        paramVarArgs.e(11, this.LSn);
      }
      AppMethodBeat.o(72476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LSk);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dNI);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.desc);
      }
      i += g.a.a.b.b.a.bu(5, this.LSl);
      paramInt = i;
      if (this.LSm != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LSm);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.count) + g.a.a.b.b.a.bu(8, this.scene);
      paramInt = i;
      if (this.GaP != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.GaP);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.sign);
      }
      paramInt = i;
      if (this.LSn != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LSn);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.dNI == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.GaP == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhy localbhy = (bhy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localbhy.LSk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localbhy.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localbhy.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localbhy.LSl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localbhy.LSm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localbhy.count = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localbhy.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localbhy.GaP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localbhy.sign = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72476);
          return 0;
        }
        localbhy.LSn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhy
 * JD-Core Version:    0.7.0.1
 */