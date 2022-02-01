package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aaf
  extends com.tencent.mm.bx.a
{
  public String FRk;
  public String FRl;
  public long FSA;
  public String FSB;
  public String FSC;
  public bmh FZd;
  public String oxN;
  public String oxO;
  public String pkr;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.oxN != null) {
        paramVarArgs.d(2, this.oxN);
      }
      if (this.oxO != null) {
        paramVarArgs.d(3, this.oxO);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aY(5, this.FSA);
      if (this.FSB != null) {
        paramVarArgs.d(6, this.FSB);
      }
      if (this.FSC != null) {
        paramVarArgs.d(7, this.FSC);
      }
      if (this.pkr != null) {
        paramVarArgs.d(8, this.pkr);
      }
      if (this.FZd != null)
      {
        paramVarArgs.lC(9, this.FZd.computeSize());
        this.FZd.writeFields(paramVarArgs);
      }
      if (this.FRk != null) {
        paramVarArgs.d(10, this.FRk);
      }
      if (this.FRl != null) {
        paramVarArgs.d(11, this.FRl);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oxN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oxN);
      }
      i = paramInt;
      if (this.oxO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oxO);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FSA);
      paramInt = i;
      if (this.FSB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FSB);
      }
      i = paramInt;
      if (this.FSC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FSC);
      }
      paramInt = i;
      if (this.pkr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pkr);
      }
      i = paramInt;
      if (this.FZd != null) {
        i = paramInt + f.a.a.a.lB(9, this.FZd.computeSize());
      }
      paramInt = i;
      if (this.FRk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FRk);
      }
      i = paramInt;
      if (this.FRl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FRl);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aaf localaaf = (aaf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localaaf.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localaaf.oxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localaaf.oxO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localaaf.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localaaf.FSA = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localaaf.FSB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localaaf.FSC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localaaf.pkr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaaf.FZd = ((bmh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localaaf.FRk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localaaf.FRl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaf
 * JD-Core Version:    0.7.0.1
 */