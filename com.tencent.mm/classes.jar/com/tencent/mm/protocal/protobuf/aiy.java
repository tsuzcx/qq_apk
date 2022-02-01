package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aiy
  extends com.tencent.mm.cd.a
{
  public LinkedList<ait> Sts;
  public String script;
  public String wdY;
  public int web;
  public int wec;
  public int wed;
  public int wef;
  public int weg;
  public int weh;
  public int wei;
  public int wej;
  public String wek;
  public String wel;
  public String wem;
  
  public aiy()
  {
    AppMethodBeat.i(252059);
    this.Sts = new LinkedList();
    AppMethodBeat.o(252059);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252062);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wdY != null) {
        paramVarArgs.f(1, this.wdY);
      }
      paramVarArgs.aY(2, this.web);
      paramVarArgs.aY(3, this.wec);
      paramVarArgs.aY(4, this.wed);
      paramVarArgs.e(5, 8, this.Sts);
      paramVarArgs.aY(6, this.wef);
      paramVarArgs.aY(7, this.wei);
      if (this.script != null) {
        paramVarArgs.f(8, this.script);
      }
      if (this.wel != null) {
        paramVarArgs.f(9, this.wel);
      }
      paramVarArgs.aY(10, this.weh);
      paramVarArgs.aY(11, this.weg);
      if (this.wem != null) {
        paramVarArgs.f(12, this.wem);
      }
      paramVarArgs.aY(13, this.wej);
      if (this.wek != null) {
        paramVarArgs.f(14, this.wek);
      }
      AppMethodBeat.o(252062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdY == null) {
        break label932;
      }
    }
    label932:
    for (paramInt = g.a.a.b.b.a.g(1, this.wdY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.web) + g.a.a.b.b.a.bM(3, this.wec) + g.a.a.b.b.a.bM(4, this.wed) + g.a.a.a.c(5, 8, this.Sts) + g.a.a.b.b.a.bM(6, this.wef) + g.a.a.b.b.a.bM(7, this.wei);
      paramInt = i;
      if (this.script != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.script);
      }
      i = paramInt;
      if (this.wel != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.wel);
      }
      i = i + g.a.a.b.b.a.bM(10, this.weh) + g.a.a.b.b.a.bM(11, this.weg);
      paramInt = i;
      if (this.wem != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.wem);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.wej);
      paramInt = i;
      if (this.wek != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.wek);
      }
      AppMethodBeat.o(252062);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sts.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(252062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aiy localaiy = (aiy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(252062);
          return -1;
        case 1: 
          localaiy.wdY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252062);
          return 0;
        case 2: 
          localaiy.web = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 3: 
          localaiy.wec = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 4: 
          localaiy.wed = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ait localait = new ait();
            if ((localObject != null) && (localObject.length > 0)) {
              localait.parseFrom((byte[])localObject);
            }
            localaiy.Sts.add(localait);
            paramInt += 1;
          }
          AppMethodBeat.o(252062);
          return 0;
        case 6: 
          localaiy.wef = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 7: 
          localaiy.wei = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 8: 
          localaiy.script = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252062);
          return 0;
        case 9: 
          localaiy.wel = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252062);
          return 0;
        case 10: 
          localaiy.weh = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 11: 
          localaiy.weg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        case 12: 
          localaiy.wem = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252062);
          return 0;
        case 13: 
          localaiy.wej = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252062);
          return 0;
        }
        localaiy.wek = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(252062);
        return 0;
      }
      AppMethodBeat.o(252062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiy
 * JD-Core Version:    0.7.0.1
 */