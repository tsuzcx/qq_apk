package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aki
  extends dyl
{
  public b SpV;
  public b SpW;
  public String SpX;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215424);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SpV != null) {
        paramVarArgs.c(2, this.SpV);
      }
      if (this.SpW != null) {
        paramVarArgs.c(3, this.SpW);
      }
      if (this.token != null) {
        paramVarArgs.f(4, this.token);
      }
      if (this.SpX != null) {
        paramVarArgs.f(101, this.SpX);
      }
      AppMethodBeat.o(215424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label548;
      }
    }
    label548:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SpV != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SpV);
      }
      i = paramInt;
      if (this.SpW != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SpW);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.token);
      }
      i = paramInt;
      if (this.SpX != null) {
        i = paramInt + g.a.a.b.b.a.g(101, this.SpX);
      }
      AppMethodBeat.o(215424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(215424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aki localaki = (aki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215424);
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
            localaki.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(215424);
          return 0;
        case 2: 
          localaki.SpV = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(215424);
          return 0;
        case 3: 
          localaki.SpW = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(215424);
          return 0;
        case 4: 
          localaki.token = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(215424);
          return 0;
        }
        localaki.SpX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(215424);
        return 0;
      }
      AppMethodBeat.o(215424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aki
 * JD-Core Version:    0.7.0.1
 */