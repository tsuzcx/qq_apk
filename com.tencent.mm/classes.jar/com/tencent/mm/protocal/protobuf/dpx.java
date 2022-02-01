package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpx
  extends dyl
{
  public eae RLV;
  public eae RQU;
  public int RRw;
  public String TCU;
  public String TKr;
  public String UserName;
  public String rVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(292383);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(292383);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.TKr != null) {
        paramVarArgs.f(3, this.TKr);
      }
      if (this.TCU != null) {
        paramVarArgs.f(4, this.TCU);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(5, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.RRw);
      if (this.rVG != null) {
        paramVarArgs.f(7, this.rVG);
      }
      if (this.RLV != null)
      {
        paramVarArgs.oE(8, this.RLV.computeSize());
        this.RLV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(292383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label892;
      }
    }
    label892:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.TKr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TKr);
      }
      paramInt = i;
      if (this.TCU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TCU);
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(5, this.RQU.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.RRw);
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.rVG);
      }
      i = paramInt;
      if (this.RLV != null) {
        i = paramInt + g.a.a.a.oD(8, this.RLV.computeSize());
      }
      AppMethodBeat.o(292383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(292383);
          throw paramVarArgs;
        }
        AppMethodBeat.o(292383);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpx localdpx = (dpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(292383);
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
            localdpx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(292383);
          return 0;
        case 2: 
          localdpx.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(292383);
          return 0;
        case 3: 
          localdpx.TKr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(292383);
          return 0;
        case 4: 
          localdpx.TCU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(292383);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localdpx.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(292383);
          return 0;
        case 6: 
          localdpx.RRw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(292383);
          return 0;
        case 7: 
          localdpx.rVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(292383);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localdpx.RLV = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(292383);
        return 0;
      }
      AppMethodBeat.o(292383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpx
 * JD-Core Version:    0.7.0.1
 */