package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class daa
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int FIY;
  public int FIZ;
  public long FJa;
  public long FJb;
  public int FJd;
  public LinkedList<dag> FJe;
  public int FJf;
  public String FJt;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public String hkR;
  public int ndI;
  public int sVo;
  
  public daa()
  {
    AppMethodBeat.i(125778);
    this.FJe = new LinkedList();
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
      paramVarArgs.aR(3, this.sVo);
      paramVarArgs.aR(4, this.ndI);
      if (this.hkR != null) {
        paramVarArgs.d(5, this.hkR);
      }
      paramVarArgs.aR(6, this.CreateTime);
      paramVarArgs.aR(7, this.FIZ);
      paramVarArgs.aR(8, this.FIY);
      if (this.FJt != null) {
        paramVarArgs.d(9, this.FJt);
      }
      paramVarArgs.aR(10, this.IsNotRichText);
      paramVarArgs.aO(11, this.FJa);
      paramVarArgs.aO(12, this.FJb);
      paramVarArgs.aR(13, this.DeleteFlag);
      paramVarArgs.aR(14, this.FJd);
      paramVarArgs.e(15, 8, this.FJe);
      paramVarArgs.aR(16, this.FJf);
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
      i = i + f.a.a.b.b.a.bx(3, this.sVo) + f.a.a.b.b.a.bx(4, this.ndI);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.CreateTime) + f.a.a.b.b.a.bx(7, this.FIZ) + f.a.a.b.b.a.bx(8, this.FIY);
      paramInt = i;
      if (this.FJt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FJt);
      }
      i = f.a.a.b.b.a.bx(10, this.IsNotRichText);
      int j = f.a.a.b.b.a.p(11, this.FJa);
      int k = f.a.a.b.b.a.p(12, this.FJb);
      int m = f.a.a.b.b.a.bx(13, this.DeleteFlag);
      int n = f.a.a.b.b.a.bx(14, this.FJd);
      int i1 = f.a.a.a.c(15, 8, this.FJe);
      int i2 = f.a.a.b.b.a.bx(16, this.FJf);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        daa localdaa = (daa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localdaa.Username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localdaa.Nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localdaa.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localdaa.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localdaa.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localdaa.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localdaa.FIZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localdaa.FIY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localdaa.FJt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localdaa.IsNotRichText = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localdaa.FJa = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localdaa.FJb = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localdaa.DeleteFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localdaa.FJd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdaa.FJe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localdaa.FJf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */