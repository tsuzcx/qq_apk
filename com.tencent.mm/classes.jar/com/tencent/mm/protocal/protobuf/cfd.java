package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cfd
  extends dyl
{
  public eae RQU;
  public eaf SrH;
  public eaf TmJ;
  public eaf TmK;
  public eae TmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155420);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.TmJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(2, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      if (this.TmJ != null)
      {
        paramVarArgs.oE(3, this.TmJ.computeSize());
        this.TmJ.writeFields(paramVarArgs);
      }
      if (this.TmK != null)
      {
        paramVarArgs.oE(4, this.TmK.computeSize());
        this.TmK.writeFields(paramVarArgs);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(5, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.TmL != null)
      {
        paramVarArgs.oE(6, this.TmL.computeSize());
        this.TmL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SrH != null) {
        paramInt = i + g.a.a.a.oD(2, this.SrH.computeSize());
      }
      i = paramInt;
      if (this.TmJ != null) {
        i = paramInt + g.a.a.a.oD(3, this.TmJ.computeSize());
      }
      paramInt = i;
      if (this.TmK != null) {
        paramInt = i + g.a.a.a.oD(4, this.TmK.computeSize());
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(5, this.RQU.computeSize());
      }
      paramInt = i;
      if (this.TmL != null) {
        paramInt = i + g.a.a.a.oD(6, this.TmL.computeSize());
      }
      AppMethodBeat.o(155420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        if (this.TmJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfd localcfd = (cfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155420);
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
            localcfd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 2: 
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
            localcfd.SrH = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
            localcfd.TmJ = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
            localcfd.TmK = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
            localcfd.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
          localcfd.TmL = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      AppMethodBeat.o(155420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfd
 * JD-Core Version:    0.7.0.1
 */