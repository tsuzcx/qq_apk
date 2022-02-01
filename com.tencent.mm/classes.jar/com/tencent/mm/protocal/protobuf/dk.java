package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dk
  extends com.tencent.mm.bx.a
{
  public String FvH;
  public String FvI;
  public String FvJ;
  public akt FvK;
  public int FvL;
  public int channel;
  public String iTJ;
  public int scene;
  public int xXA;
  public String xZb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.FvJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.FvH != null) {
        paramVarArgs.d(1, this.FvH);
      }
      if (this.FvI != null) {
        paramVarArgs.d(2, this.FvI);
      }
      paramVarArgs.aS(3, this.channel);
      paramVarArgs.aS(4, this.xXA);
      paramVarArgs.aS(5, this.scene);
      if (this.FvJ != null) {
        paramVarArgs.d(6, this.FvJ);
      }
      if (this.FvK != null)
      {
        paramVarArgs.lC(7, this.FvK.computeSize());
        this.FvK.writeFields(paramVarArgs);
      }
      if (this.iTJ != null) {
        paramVarArgs.d(8, this.iTJ);
      }
      if (this.xZb != null) {
        paramVarArgs.d(9, this.xZb);
      }
      paramVarArgs.aS(10, this.FvL);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FvH == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.FvH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FvI);
      }
      i = i + f.a.a.b.b.a.bz(3, this.channel) + f.a.a.b.b.a.bz(4, this.xXA) + f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.FvJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FvJ);
      }
      i = paramInt;
      if (this.FvK != null) {
        i = paramInt + f.a.a.a.lB(7, this.FvK.computeSize());
      }
      paramInt = i;
      if (this.iTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iTJ);
      }
      i = paramInt;
      if (this.xZb != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.xZb);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FvL);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.FvJ == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dk localdk = (dk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localdk.FvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localdk.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localdk.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localdk.xXA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localdk.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localdk.FvJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((akt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdk.FvK = ((akt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localdk.iTJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localdk.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localdk.FvL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */