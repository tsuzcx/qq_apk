package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiy
  extends com.tencent.mm.cd.a
{
  public int GIu;
  public String Sdn;
  public dp Tgx;
  public LinkedList<doo> UkR;
  public alj UkS;
  public LinkedList<dtx> UkT;
  public int UkU;
  
  public eiy()
  {
    AppMethodBeat.i(91694);
    this.UkR = new LinkedList();
    this.UkT = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GIu);
      paramVarArgs.e(2, 8, this.UkR);
      if (this.UkS != null)
      {
        paramVarArgs.oE(3, this.UkS.computeSize());
        this.UkS.writeFields(paramVarArgs);
      }
      if (this.Tgx != null)
      {
        paramVarArgs.oE(4, this.Tgx.computeSize());
        this.Tgx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.UkT);
      paramVarArgs.aY(6, this.UkU);
      if (this.Sdn != null) {
        paramVarArgs.f(7, this.Sdn);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.GIu) + 0 + g.a.a.a.c(2, 8, this.UkR);
      paramInt = i;
      if (this.UkS != null) {
        paramInt = i + g.a.a.a.oD(3, this.UkS.computeSize());
      }
      i = paramInt;
      if (this.Tgx != null) {
        i = paramInt + g.a.a.a.oD(4, this.Tgx.computeSize());
      }
      i = i + g.a.a.a.c(5, 8, this.UkT) + g.a.a.b.b.a.bM(6, this.UkU);
      paramInt = i;
      if (this.Sdn != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sdn);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UkR.clear();
      this.UkT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eiy localeiy = (eiy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localeiy.GIu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new doo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((doo)localObject2).parseFrom((byte[])localObject1);
          }
          localeiy.UkR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new alj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((alj)localObject2).parseFrom((byte[])localObject1);
          }
          localeiy.UkS = ((alj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dp)localObject2).parseFrom((byte[])localObject1);
          }
          localeiy.Tgx = ((dp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtx)localObject2).parseFrom((byte[])localObject1);
          }
          localeiy.UkT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localeiy.UkU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91695);
        return 0;
      }
      localeiy.Sdn = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiy
 * JD-Core Version:    0.7.0.1
 */