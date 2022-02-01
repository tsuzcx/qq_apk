package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cr
  extends dyl
{
  public LinkedList<cwz> RIk;
  public eaf RIl;
  public int RIm;
  public String RIn;
  public cju RIo;
  public int iWB;
  
  public cr()
  {
    AppMethodBeat.i(101790);
    this.RIk = new LinkedList();
    AppMethodBeat.o(101790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.iWB);
      paramVarArgs.e(3, 8, this.RIk);
      if (this.RIl != null)
      {
        paramVarArgs.oE(4, this.RIl.computeSize());
        this.RIl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.RIm);
      if (this.RIn != null) {
        paramVarArgs.f(6, this.RIn);
      }
      if (this.RIo != null)
      {
        paramVarArgs.oE(7, this.RIo.computeSize());
        this.RIo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label870;
      }
    }
    label870:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.iWB) + g.a.a.a.c(3, 8, this.RIk);
      paramInt = i;
      if (this.RIl != null) {
        paramInt = i + g.a.a.a.oD(4, this.RIl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RIm);
      paramInt = i;
      if (this.RIn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIn);
      }
      i = paramInt;
      if (this.RIo != null) {
        i = paramInt + g.a.a.a.oD(7, this.RIo.computeSize());
      }
      AppMethodBeat.o(101791);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101791);
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
            localcr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 2: 
          localcr.iWB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101791);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cwz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cwz)localObject2).parseFrom((byte[])localObject1);
            }
            localcr.RIk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
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
            localcr.RIl = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 5: 
          localcr.RIm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101791);
          return 0;
        case 6: 
          localcr.RIn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101791);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cju();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cju)localObject2).parseFrom((byte[])localObject1);
          }
          localcr.RIo = ((cju)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      AppMethodBeat.o(101791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */