package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuo
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int ElZ;
  public int Ema;
  public long Emb;
  public long Emc;
  public int Eme;
  public LinkedList<cuu> Emf;
  public int Emg;
  public String Emu;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public String gKr;
  public int mBH;
  public int rNz;
  
  public cuo()
  {
    AppMethodBeat.i(125778);
    this.Emf = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      paramVarArgs.aR(3, this.rNz);
      paramVarArgs.aR(4, this.mBH);
      if (this.gKr != null) {
        paramVarArgs.d(5, this.gKr);
      }
      paramVarArgs.aR(6, this.CreateTime);
      paramVarArgs.aR(7, this.Ema);
      paramVarArgs.aR(8, this.ElZ);
      if (this.Emu != null) {
        paramVarArgs.d(9, this.Emu);
      }
      paramVarArgs.aR(10, this.IsNotRichText);
      paramVarArgs.aG(11, this.Emb);
      paramVarArgs.aG(12, this.Emc);
      paramVarArgs.aR(13, this.DeleteFlag);
      paramVarArgs.aR(14, this.Eme);
      paramVarArgs.e(15, 8, this.Emf);
      paramVarArgs.aR(16, this.Emg);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1050;
      }
    }
    label1050:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = i + f.a.a.b.b.a.bA(3, this.rNz) + f.a.a.b.b.a.bA(4, this.mBH);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CreateTime) + f.a.a.b.b.a.bA(7, this.Ema) + f.a.a.b.b.a.bA(8, this.ElZ);
      paramInt = i;
      if (this.Emu != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Emu);
      }
      i = f.a.a.b.b.a.bA(10, this.IsNotRichText);
      int j = f.a.a.b.b.a.q(11, this.Emb);
      int k = f.a.a.b.b.a.q(12, this.Emc);
      int m = f.a.a.b.b.a.bA(13, this.DeleteFlag);
      int n = f.a.a.b.b.a.bA(14, this.Eme);
      int i1 = f.a.a.a.c(15, 8, this.Emf);
      int i2 = f.a.a.b.b.a.bA(16, this.Emg);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Emf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuo localcuo = (cuo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localcuo.Username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localcuo.Nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localcuo.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localcuo.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localcuo.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localcuo.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localcuo.Ema = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localcuo.ElZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localcuo.Emu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localcuo.IsNotRichText = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localcuo.Emb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localcuo.Emc = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localcuo.DeleteFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localcuo.Eme = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cuu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuo.Emf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localcuo.Emg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuo
 * JD-Core Version:    0.7.0.1
 */