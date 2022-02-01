package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dir
  extends dyy
{
  public LinkedList<rt> TQd;
  public String TQe;
  public String TQf;
  public String TQg;
  public epm TQh;
  public String TQi;
  public String Tky;
  public epm TwM;
  
  public dir()
  {
    AppMethodBeat.i(117890);
    this.TQd = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tky != null) {
        paramVarArgs.f(2, this.Tky);
      }
      if (this.TwM != null)
      {
        paramVarArgs.oE(3, this.TwM.computeSize());
        this.TwM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.TQd);
      if (this.TQe != null) {
        paramVarArgs.f(5, this.TQe);
      }
      if (this.TQf != null) {
        paramVarArgs.f(6, this.TQf);
      }
      if (this.TQg != null) {
        paramVarArgs.f(7, this.TQg);
      }
      if (this.TQh != null)
      {
        paramVarArgs.oE(8, this.TQh.computeSize());
        this.TQh.writeFields(paramVarArgs);
      }
      if (this.TQi != null) {
        paramVarArgs.f(9, this.TQi);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label978;
      }
    }
    label978:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tky);
      }
      i = paramInt;
      if (this.TwM != null) {
        i = paramInt + g.a.a.a.oD(3, this.TwM.computeSize());
      }
      i += g.a.a.a.c(4, 8, this.TQd);
      paramInt = i;
      if (this.TQe != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TQe);
      }
      i = paramInt;
      if (this.TQf != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TQf);
      }
      paramInt = i;
      if (this.TQg != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TQg);
      }
      i = paramInt;
      if (this.TQh != null) {
        i = paramInt + g.a.a.a.oD(8, this.TQh.computeSize());
      }
      paramInt = i;
      if (this.TQi != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TQi);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TQd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dir localdir = (dir)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdir.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localdir.Tky = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epm)localObject2).parseFrom((byte[])localObject1);
            }
            localdir.TwM = ((epm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rt)localObject2).parseFrom((byte[])localObject1);
            }
            localdir.TQd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localdir.TQe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localdir.TQf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localdir.TQg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epm)localObject2).parseFrom((byte[])localObject1);
            }
            localdir.TQh = ((epm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localdir.TQi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dir
 * JD-Core Version:    0.7.0.1
 */