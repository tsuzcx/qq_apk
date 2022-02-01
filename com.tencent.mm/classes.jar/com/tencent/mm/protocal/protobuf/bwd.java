package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwd
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public dhg GOa;
  public acf GOb;
  public aii GQk;
  public String Guj;
  public String Nickname;
  public String Username;
  public String jdb;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public int jdi;
  public int jdj;
  public String jdk;
  public String jdl;
  public String jdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      if (this.jdb != null) {
        paramVarArgs.d(3, this.jdb);
      }
      paramVarArgs.aS(4, this.jdc);
      if (this.jdd != null) {
        paramVarArgs.d(5, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(6, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(7, this.jdf);
      }
      paramVarArgs.aS(8, this.jdg);
      if (this.jdh != null) {
        paramVarArgs.d(9, this.jdh);
      }
      if (this.GQk != null)
      {
        paramVarArgs.lC(10, this.GQk.computeSize());
        this.GQk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.jdi);
      paramVarArgs.aS(12, this.jdj);
      if (this.jdk != null) {
        paramVarArgs.d(13, this.jdk);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(14, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(15, this.jdl);
      }
      if (this.jdm != null) {
        paramVarArgs.d(16, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(17, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(20, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(21, this.FVp);
      }
      if (this.Guj != null) {
        paramVarArgs.d(22, this.Guj);
      }
      AppMethodBeat.o(155440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1610;
      }
    }
    label1610:
    for (int i = f.a.a.b.b.a.e(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = paramInt;
      if (this.jdb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jdb);
      }
      i += f.a.a.b.b.a.bz(4, this.jdc);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.jdg);
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jdh);
      }
      i = paramInt;
      if (this.GQk != null) {
        i = paramInt + f.a.a.a.lB(10, this.GQk.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(11, this.jdi) + f.a.a.b.b.a.bz(12, this.jdj);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jdk);
      }
      i = paramInt;
      if (this.GOa != null) {
        i = paramInt + f.a.a.a.lB(14, this.GOa.computeSize());
      }
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jdl);
      }
      i = paramInt;
      if (this.jdm != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.jdm);
      }
      paramInt = i;
      if (this.GOb != null) {
        paramInt = i + f.a.a.a.lB(17, this.GOb.computeSize());
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FVp);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.Guj);
      }
      AppMethodBeat.o(155440);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwd localbwd = (bwd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(155440);
          return -1;
        case 1: 
          localbwd.Username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 2: 
          localbwd.Nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 3: 
          localbwd.jdb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 4: 
          localbwd.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 5: 
          localbwd.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 6: 
          localbwd.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 7: 
          localbwd.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 8: 
          localbwd.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 9: 
          localbwd.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwd.GQk = ((aii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 11: 
          localbwd.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 12: 
          localbwd.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155440);
          return 0;
        case 13: 
          localbwd.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwd.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 15: 
          localbwd.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 16: 
          localbwd.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwd.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155440);
          return 0;
        case 20: 
          localbwd.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        case 21: 
          localbwd.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155440);
          return 0;
        }
        localbwd.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155440);
        return 0;
      }
      AppMethodBeat.o(155440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwd
 * JD-Core Version:    0.7.0.1
 */