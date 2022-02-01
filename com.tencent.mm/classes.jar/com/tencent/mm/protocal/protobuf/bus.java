package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bus
  extends dyl
{
  public String TeR;
  public b TeS;
  public int live_type;
  public int scene;
  public String ufq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      if (this.ufq != null) {
        paramVarArgs.f(3, this.ufq);
      }
      if (this.TeR != null) {
        paramVarArgs.f(4, this.TeR);
      }
      paramVarArgs.aY(5, this.live_type);
      if (this.TeS != null) {
        paramVarArgs.c(6, this.TeS);
      }
      AppMethodBeat.o(104369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.ufq != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ufq);
      }
      i = paramInt;
      if (this.TeR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TeR);
      }
      i += g.a.a.b.b.a.bM(5, this.live_type);
      paramInt = i;
      if (this.TeS != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.TeS);
      }
      AppMethodBeat.o(104369);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104369);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104369);
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
            localbus.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(104369);
          return 0;
        case 2: 
          localbus.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104369);
          return 0;
        case 3: 
          localbus.ufq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104369);
          return 0;
        case 4: 
          localbus.TeR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104369);
          return 0;
        case 5: 
          localbus.live_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104369);
          return 0;
        }
        localbus.TeS = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(104369);
        return 0;
      }
      AppMethodBeat.o(104369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */