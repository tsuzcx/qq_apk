package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egm
  extends dyl
{
  public String HlB;
  public eae RLV;
  public int Ujg;
  public String vhh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vhh != null) {
        paramVarArgs.f(2, this.vhh);
      }
      if (this.HlB != null) {
        paramVarArgs.f(3, this.HlB);
      }
      if (this.RLV != null)
      {
        paramVarArgs.oE(4, this.RLV.computeSize());
        this.RLV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Ujg);
      AppMethodBeat.o(134257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhh != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.vhh);
      }
      i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.HlB);
      }
      paramInt = i;
      if (this.RLV != null) {
        paramInt = i + g.a.a.a.oD(4, this.RLV.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.Ujg);
      AppMethodBeat.o(134257);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(134257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egm localegm = (egm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134257);
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
            localegm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        case 2: 
          localegm.vhh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 3: 
          localegm.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134257);
          return 0;
        case 4: 
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
            localegm.RLV = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134257);
          return 0;
        }
        localegm.Ujg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(134257);
        return 0;
      }
      AppMethodBeat.o(134257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egm
 * JD-Core Version:    0.7.0.1
 */