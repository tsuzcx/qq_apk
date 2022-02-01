package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byp
  extends dyl
{
  public int HlE;
  public long HlH;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eaf RID;
  public eaf RIE;
  public int ThK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HlE);
      if (this.RID != null)
      {
        paramVarArgs.oE(3, this.RID.computeSize());
        this.RID.writeFields(paramVarArgs);
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(4, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.HmZ);
      paramVarArgs.aY(6, this.Hna);
      paramVarArgs.aY(7, this.Hnb);
      paramVarArgs.aY(8, this.ThK);
      paramVarArgs.bm(9, this.HlH);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label928;
      }
    }
    label928:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.HlE);
      paramInt = i;
      if (this.RID != null) {
        paramInt = i + g.a.a.a.oD(3, this.RID.computeSize());
      }
      i = paramInt;
      if (this.RIE != null) {
        i = paramInt + g.a.a.a.oD(4, this.RIE.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(5, this.HmZ);
      int j = g.a.a.b.b.a.bM(6, this.Hna);
      int k = g.a.a.b.b.a.bM(7, this.Hnb);
      int m = g.a.a.b.b.a.bM(8, this.ThK);
      int n = g.a.a.b.b.a.p(9, this.HlH);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RID == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.RIE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byp localbyp = (byp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbyp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localbyp.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152572);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbyp.RID = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localbyp.RIE = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localbyp.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localbyp.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localbyp.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localbyp.ThK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152572);
          return 0;
        }
        localbyp.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */