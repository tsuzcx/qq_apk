package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dk
  extends com.tencent.mm.bw.a
{
  public String FOf;
  public String FOg;
  public String FOh;
  public ald FOi;
  public int FOj;
  public int channel;
  public String iWC;
  public int scene;
  public int yns;
  public String yoT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.FOh == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.FOf != null) {
        paramVarArgs.d(1, this.FOf);
      }
      if (this.FOg != null) {
        paramVarArgs.d(2, this.FOg);
      }
      paramVarArgs.aS(3, this.channel);
      paramVarArgs.aS(4, this.yns);
      paramVarArgs.aS(5, this.scene);
      if (this.FOh != null) {
        paramVarArgs.d(6, this.FOh);
      }
      if (this.FOi != null)
      {
        paramVarArgs.lJ(7, this.FOi.computeSize());
        this.FOi.writeFields(paramVarArgs);
      }
      if (this.iWC != null) {
        paramVarArgs.d(8, this.iWC);
      }
      if (this.yoT != null) {
        paramVarArgs.d(9, this.yoT);
      }
      paramVarArgs.aS(10, this.FOj);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOf == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.FOf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FOg);
      }
      i = i + f.a.a.b.b.a.bz(3, this.channel) + f.a.a.b.b.a.bz(4, this.yns) + f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.FOh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FOh);
      }
      i = paramInt;
      if (this.FOi != null) {
        i = paramInt + f.a.a.a.lI(7, this.FOi.computeSize());
      }
      paramInt = i;
      if (this.iWC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iWC);
      }
      i = paramInt;
      if (this.yoT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.yoT);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FOj);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.FOh == null)
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
          localdk.FOf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localdk.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localdk.channel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localdk.yns = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localdk.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localdk.FOh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ald();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdk.FOi = ((ald)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localdk.iWC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localdk.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localdk.FOj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */