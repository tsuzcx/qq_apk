package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cea
  extends dop
{
  public int LEg;
  public String MjD;
  public String MjE;
  public int MjF;
  public String MjG;
  public String MjH;
  public String dNI;
  public String packageName;
  public int qwp;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.MjD != null) {
        paramVarArgs.e(3, this.MjD);
      }
      paramVarArgs.aM(4, this.scene);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.MjE != null) {
        paramVarArgs.e(6, this.MjE);
      }
      paramVarArgs.aM(7, this.qwp);
      paramVarArgs.aM(8, this.LEg);
      paramVarArgs.aM(9, this.MjF);
      if (this.MjG != null) {
        paramVarArgs.e(10, this.MjG);
      }
      if (this.packageName != null) {
        paramVarArgs.e(11, this.packageName);
      }
      if (this.MjH != null) {
        paramVarArgs.e(12, this.MjH);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label918;
      }
    }
    label918:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.MjD != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MjD);
      }
      i += g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt;
      if (this.MjE != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MjE);
      }
      i = i + g.a.a.b.b.a.bu(7, this.qwp) + g.a.a.b.b.a.bu(8, this.LEg) + g.a.a.b.b.a.bu(9, this.MjF);
      paramInt = i;
      if (this.MjG != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MjG);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.packageName);
      }
      paramInt = i;
      if (this.MjH != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MjH);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcea.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localcea.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localcea.MjD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localcea.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localcea.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localcea.MjE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localcea.qwp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localcea.LEg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localcea.MjF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localcea.MjG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localcea.packageName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localcea.MjH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */