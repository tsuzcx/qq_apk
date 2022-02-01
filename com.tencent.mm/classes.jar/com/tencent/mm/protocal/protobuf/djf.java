package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djf
  extends dyl
{
  public String GIh;
  public int GIo;
  public String GIz;
  public bd Sdp;
  public int TQH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TQH);
      if (this.GIh != null) {
        paramVarArgs.f(3, this.GIh);
      }
      paramVarArgs.aY(4, this.GIo);
      if (this.GIz != null) {
        paramVarArgs.f(5, this.GIz);
      }
      if (this.Sdp != null)
      {
        paramVarArgs.oE(6, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TQH);
      paramInt = i;
      if (this.GIh != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.GIh);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.GIo);
      paramInt = i;
      if (this.GIz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.GIz);
      }
      i = paramInt;
      if (this.Sdp != null) {
        i = paramInt + g.a.a.a.oD(6, this.Sdp.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djf localdjf = (djf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
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
            localdjf.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localdjf.TQH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localdjf.GIh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localdjf.GIo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localdjf.GIz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bd)localObject2).parseFrom((byte[])localObject1);
          }
          localdjf.Sdp = ((bd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djf
 * JD-Core Version:    0.7.0.1
 */