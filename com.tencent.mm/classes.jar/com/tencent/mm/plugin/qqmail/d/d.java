package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class d
  extends dyl
{
  public String HlA;
  public String HlB;
  public String HlC;
  public int Hly;
  public String Hlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Hly);
      if (this.Hlz != null) {
        paramVarArgs.f(3, this.Hlz);
      }
      if (this.HlA != null) {
        paramVarArgs.f(4, this.HlA);
      }
      if (this.HlB != null) {
        paramVarArgs.f(5, this.HlB);
      }
      if (this.HlC != null) {
        paramVarArgs.f(6, this.HlC);
      }
      AppMethodBeat.o(250281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Hly);
      paramInt = i;
      if (this.Hlz != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Hlz);
      }
      i = paramInt;
      if (this.HlA != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.HlA);
      }
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.HlB);
      }
      i = paramInt;
      if (this.HlC != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.HlC);
      }
      AppMethodBeat.o(250281);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250281);
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
            locald.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(250281);
          return 0;
        case 2: 
          locald.Hly = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(250281);
          return 0;
        case 3: 
          locald.Hlz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250281);
          return 0;
        case 4: 
          locald.HlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250281);
          return 0;
        case 5: 
          locald.HlB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250281);
          return 0;
        }
        locald.HlC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(250281);
        return 0;
      }
      AppMethodBeat.o(250281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.d
 * JD-Core Version:    0.7.0.1
 */