package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edh
  extends dop
{
  public edf NdH;
  public edf NdI;
  public int NdJ;
  public int NdK;
  public String SessionId;
  public String izX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NdH == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(2, this.izX);
      }
      if (this.NdH != null)
      {
        paramVarArgs.ni(3, this.NdH.computeSize());
        this.NdH.writeFields(paramVarArgs);
      }
      if (this.NdI != null)
      {
        paramVarArgs.ni(6, this.NdI.computeSize());
        this.NdI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.NdJ);
      paramVarArgs.aM(5, this.NdK);
      if (this.SessionId != null) {
        paramVarArgs.e(7, this.SessionId);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.izX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.izX);
      }
      i = paramInt;
      if (this.NdH != null) {
        i = paramInt + g.a.a.a.nh(3, this.NdH.computeSize());
      }
      paramInt = i;
      if (this.NdI != null) {
        paramInt = i + g.a.a.a.nh(6, this.NdI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.NdJ) + g.a.a.b.b.a.bu(5, this.NdK);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.SessionId);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NdH == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edh localedh = (edh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
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
            localedh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localedh.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localedh.NdH = ((edf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localedh.NdI = ((edf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localedh.NdJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localedh.NdK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118439);
          return 0;
        }
        localedh.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edh
 * JD-Core Version:    0.7.0.1
 */