package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yx
  extends dop
{
  public String LaE;
  public int LjY;
  public String fileid;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9588);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null)
      {
        paramVarArgs = new b("Not all required fields were included: fileid");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.e(2, this.fileid);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      if (this.LaE != null) {
        paramVarArgs.e(4, this.LaE);
      }
      paramVarArgs.aM(5, this.LjY);
      AppMethodBeat.o(9588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.fileid);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      paramInt = i;
      if (this.LaE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LaE);
      }
      i = g.a.a.b.b.a.bu(5, this.LjY);
      AppMethodBeat.o(9588);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.fileid == null)
        {
          paramVarArgs = new b("Not all required fields were included: fileid");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9588);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yx localyx = (yx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9588);
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
            localyx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9588);
          return 0;
        case 2: 
          localyx.fileid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 3: 
          localyx.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 4: 
          localyx.LaE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9588);
          return 0;
        }
        localyx.LjY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(9588);
        return 0;
      }
      AppMethodBeat.o(9588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yx
 * JD-Core Version:    0.7.0.1
 */