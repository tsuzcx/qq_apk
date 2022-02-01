package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eh
  extends com.tencent.mm.bx.a
{
  public int OhP;
  public asl OiK;
  public String Oiw;
  public LinkedList<apu> Oiy;
  public String Oln;
  public String YGt;
  public String YGu;
  public int YGv;
  public int channel;
  public String nQU;
  public int scene;
  
  public eh()
  {
    AppMethodBeat.i(259010);
    this.Oiy = new LinkedList();
    AppMethodBeat.o(259010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGt == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.YGu == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.YGt != null) {
        paramVarArgs.g(1, this.YGt);
      }
      if (this.Oln != null) {
        paramVarArgs.g(2, this.Oln);
      }
      paramVarArgs.bS(3, this.channel);
      paramVarArgs.bS(4, this.OhP);
      paramVarArgs.bS(5, this.scene);
      if (this.YGu != null) {
        paramVarArgs.g(6, this.YGu);
      }
      if (this.OiK != null)
      {
        paramVarArgs.qD(7, this.OiK.computeSize());
        this.OiK.writeFields(paramVarArgs);
      }
      if (this.nQU != null) {
        paramVarArgs.g(8, this.nQU);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(9, this.Oiw);
      }
      paramVarArgs.bS(10, this.YGv);
      paramVarArgs.e(11, 8, this.Oiy);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGt == null) {
        break label986;
      }
    }
    label986:
    for (paramInt = i.a.a.b.b.a.h(1, this.YGt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Oln);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.channel) + i.a.a.b.b.a.cJ(4, this.OhP) + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.YGu != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YGu);
      }
      i = paramInt;
      if (this.OiK != null) {
        i = paramInt + i.a.a.a.qC(7, this.OiK.computeSize());
      }
      paramInt = i;
      if (this.nQU != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.nQU);
      }
      i = paramInt;
      if (this.Oiw != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Oiw);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.YGv);
      int j = i.a.a.a.c(11, 8, this.Oiy);
      AppMethodBeat.o(91349);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Oiy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YGt == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.YGu == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eh localeh = (eh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localeh.YGt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localeh.Oln = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localeh.channel = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localeh.OhP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localeh.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localeh.YGu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asl)localObject2).parseFrom((byte[])localObject1);
            }
            localeh.OiK = ((asl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localeh.nQU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localeh.Oiw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 10: 
          localeh.YGv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91349);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new apu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((apu)localObject2).parseFrom((byte[])localObject1);
          }
          localeh.Oiy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eh
 * JD-Core Version:    0.7.0.1
 */