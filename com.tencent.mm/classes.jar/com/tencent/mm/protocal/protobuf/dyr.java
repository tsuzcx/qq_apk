package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dyr
  extends com.tencent.mm.cd.a
{
  public int QZD;
  public int Scv;
  public int TVM;
  public int Tfy;
  public int TrM;
  public dyu Uer;
  public dyt Ues;
  public int Uet;
  public String Ueu;
  public int Uev;
  public int Uew;
  public int Uex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueu == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.TVM);
      if (this.Uer != null)
      {
        paramVarArgs.oE(2, this.Uer.computeSize());
        this.Uer.writeFields(paramVarArgs);
      }
      if (this.Ues != null)
      {
        paramVarArgs.oE(3, this.Ues.computeSize());
        this.Ues.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Tfy);
      paramVarArgs.aY(5, this.Uet);
      if (this.Ueu != null) {
        paramVarArgs.f(6, this.Ueu);
      }
      paramVarArgs.aY(7, this.Scv);
      paramVarArgs.aY(8, this.Uev);
      paramVarArgs.aY(9, this.QZD);
      paramVarArgs.aY(10, this.Uew);
      paramVarArgs.aY(11, this.Uex);
      paramVarArgs.aY(12, this.TrM);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TVM) + 0;
      paramInt = i;
      if (this.Uer != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uer.computeSize());
      }
      i = paramInt;
      if (this.Ues != null) {
        i = paramInt + g.a.a.a.oD(3, this.Ues.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(4, this.Tfy) + g.a.a.b.b.a.bM(5, this.Uet);
      paramInt = i;
      if (this.Ueu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Ueu);
      }
      i = g.a.a.b.b.a.bM(7, this.Scv);
      int j = g.a.a.b.b.a.bM(8, this.Uev);
      int k = g.a.a.b.b.a.bM(9, this.QZD);
      int m = g.a.a.b.b.a.bM(10, this.Uew);
      int n = g.a.a.b.b.a.bM(11, this.Uex);
      int i1 = g.a.a.b.b.a.bM(12, this.TrM);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Ueu == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dyr localdyr = (dyr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localdyr.TVM = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyu)localObject2).parseFrom((byte[])localObject1);
          }
          localdyr.Uer = ((dyu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyt)localObject2).parseFrom((byte[])localObject1);
          }
          localdyr.Ues = ((dyt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localdyr.Tfy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localdyr.Uet = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localdyr.Ueu = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localdyr.Scv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localdyr.Uev = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localdyr.QZD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localdyr.Uew = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localdyr.Uex = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152668);
        return 0;
      }
      localdyr.TrM = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyr
 * JD-Core Version:    0.7.0.1
 */