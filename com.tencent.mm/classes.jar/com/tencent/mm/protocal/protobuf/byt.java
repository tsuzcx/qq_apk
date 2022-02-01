package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byt
  extends com.tencent.mm.bw.a
{
  public String BgA;
  public String BgB;
  public int Bgu;
  public String Bgw;
  public String Bgx;
  public String Bgy;
  public String Bgz;
  public int Bik;
  public byu FnP;
  public String FnQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Bik);
      if (this.FnP != null)
      {
        paramVarArgs.ln(2, this.FnP.computeSize());
        this.FnP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Bgu);
      if (this.Bgw != null) {
        paramVarArgs.d(4, this.Bgw);
      }
      if (this.Bgx != null) {
        paramVarArgs.d(5, this.Bgx);
      }
      if (this.Bgy != null) {
        paramVarArgs.d(6, this.Bgy);
      }
      if (this.Bgz != null) {
        paramVarArgs.d(7, this.Bgz);
      }
      if (this.BgA != null) {
        paramVarArgs.d(8, this.BgA);
      }
      if (this.BgB != null) {
        paramVarArgs.d(9, this.BgB);
      }
      if (this.FnQ != null) {
        paramVarArgs.d(10, this.FnQ);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Bik) + 0;
      paramInt = i;
      if (this.FnP != null) {
        paramInt = i + f.a.a.a.lm(2, this.FnP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.Bgu);
      paramInt = i;
      if (this.Bgw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Bgw);
      }
      i = paramInt;
      if (this.Bgx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Bgx);
      }
      paramInt = i;
      if (this.Bgy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Bgy);
      }
      i = paramInt;
      if (this.Bgz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Bgz);
      }
      paramInt = i;
      if (this.BgA != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.BgA);
      }
      i = paramInt;
      if (this.BgB != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.BgB);
      }
      paramInt = i;
      if (this.FnQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FnQ);
      }
      AppMethodBeat.o(72526);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byt localbyt = (byt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localbyt.Bik = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((byu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyt.FnP = ((byu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localbyt.Bgu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localbyt.Bgw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localbyt.Bgx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localbyt.Bgy = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localbyt.Bgz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localbyt.BgA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localbyt.BgB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localbyt.FnQ = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byt
 * JD-Core Version:    0.7.0.1
 */