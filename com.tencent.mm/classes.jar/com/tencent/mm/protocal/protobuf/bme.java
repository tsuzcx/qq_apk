package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bme
  extends dyl
{
  public String gbn;
  public int limit;
  public int msgType;
  public int offset;
  public int scene;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gbn != null) {
        paramVarArgs.f(2, this.gbn);
      }
      paramVarArgs.aY(3, this.limit);
      paramVarArgs.aY(4, this.offset);
      if (this.ybP != null) {
        paramVarArgs.f(5, this.ybP);
      }
      paramVarArgs.aY(6, this.msgType);
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(211577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gbn != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.gbn);
      }
      i = i + g.a.a.b.b.a.bM(3, this.limit) + g.a.a.b.b.a.bM(4, this.offset);
      paramInt = i;
      if (this.ybP != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ybP);
      }
      i = g.a.a.b.b.a.bM(6, this.msgType);
      int j = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(211577);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211577);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bme localbme = (bme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211577);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbme.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(211577);
          return 0;
        case 2: 
          localbme.gbn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211577);
          return 0;
        case 3: 
          localbme.limit = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(211577);
          return 0;
        case 4: 
          localbme.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(211577);
          return 0;
        case 5: 
          localbme.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211577);
          return 0;
        case 6: 
          localbme.msgType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(211577);
          return 0;
        }
        localbme.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(211577);
        return 0;
      }
      AppMethodBeat.o(211577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bme
 * JD-Core Version:    0.7.0.1
 */