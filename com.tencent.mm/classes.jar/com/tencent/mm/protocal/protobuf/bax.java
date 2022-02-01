package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bax
  extends com.tencent.mm.bw.a
{
  public cvv GQP;
  public boolean GQV;
  public boolean GQW;
  public String GQX;
  public int GQk;
  public int Gdm;
  public int drN;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.drN);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.GQk);
      paramVarArgs.aS(5, this.Gdm);
      paramVarArgs.bC(6, this.GQV);
      paramVarArgs.bC(7, this.GQW);
      if (this.GQP != null)
      {
        paramVarArgs.lJ(20, this.GQP.computeSize());
        this.GQP.writeFields(paramVarArgs);
      }
      if (this.GQX != null) {
        paramVarArgs.d(21, this.GQX);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.drN) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GQk) + f.a.a.b.b.a.bz(5, this.Gdm) + f.a.a.b.b.a.amF(6) + f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.GQP != null) {
        paramInt = i + f.a.a.a.lI(20, this.GQP.computeSize());
      }
      i = paramInt;
      if (this.GQX != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.GQX);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bax localbax = (bax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localbax.drN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localbax.url = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localbax.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localbax.GQk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localbax.Gdm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localbax.GQV = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localbax.GQW = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cvv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbax.GQP = ((cvv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localbax.GQX = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bax
 * JD-Core Version:    0.7.0.1
 */