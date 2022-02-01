package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exs
  extends dyl
{
  public int HmZ;
  public int Hna;
  public eae Hnc;
  public eae RMN;
  public int Tfx;
  public String UserName;
  public String UxW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152717);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HmZ);
      paramVarArgs.aY(3, this.Hna);
      paramVarArgs.aY(4, this.Tfx);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(5, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      if (this.UxW != null) {
        paramVarArgs.f(6, this.UxW);
      }
      if (this.UserName != null) {
        paramVarArgs.f(7, this.UserName);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(8, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label856;
      }
    }
    label856:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.HmZ) + g.a.a.b.b.a.bM(3, this.Hna) + g.a.a.b.b.a.bM(4, this.Tfx);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(5, this.Hnc.computeSize());
      }
      i = paramInt;
      if (this.UxW != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UxW);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UserName);
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(8, this.RMN.computeSize());
      }
      AppMethodBeat.o(152717);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152717);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exs localexs = (exs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152717);
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
            localexs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 2: 
          localexs.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152717);
          return 0;
        case 3: 
          localexs.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152717);
          return 0;
        case 4: 
          localexs.Tfx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152717);
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
            localexs.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152717);
          return 0;
        case 6: 
          localexs.UxW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152717);
          return 0;
        case 7: 
          localexs.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152717);
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
          localexs.RMN = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152717);
        return 0;
      }
      AppMethodBeat.o(152717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exs
 * JD-Core Version:    0.7.0.1
 */