package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fdv
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int IcB;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public String abDA;
  public int abDg;
  public int abDh;
  public long abDi;
  public long abDj;
  public int abDl;
  public LinkedList<feb> abDm;
  public int abDn;
  public String nUB;
  public int vhJ;
  
  public fdv()
  {
    AppMethodBeat.i(125778);
    this.abDm = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.g(2, this.Nickname);
      }
      paramVarArgs.bS(3, this.IcB);
      paramVarArgs.bS(4, this.vhJ);
      if (this.nUB != null) {
        paramVarArgs.g(5, this.nUB);
      }
      paramVarArgs.bS(6, this.CreateTime);
      paramVarArgs.bS(7, this.abDh);
      paramVarArgs.bS(8, this.abDg);
      if (this.abDA != null) {
        paramVarArgs.g(9, this.abDA);
      }
      paramVarArgs.bS(10, this.IsNotRichText);
      paramVarArgs.bv(11, this.abDi);
      paramVarArgs.bv(12, this.abDj);
      paramVarArgs.bS(13, this.DeleteFlag);
      paramVarArgs.bS(14, this.abDl);
      paramVarArgs.e(15, 8, this.abDm);
      paramVarArgs.bS(16, this.abDn);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1024;
      }
    }
    label1024:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Nickname);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.IcB) + i.a.a.b.b.a.cJ(4, this.vhJ);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.CreateTime) + i.a.a.b.b.a.cJ(7, this.abDh) + i.a.a.b.b.a.cJ(8, this.abDg);
      paramInt = i;
      if (this.abDA != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abDA);
      }
      i = i.a.a.b.b.a.cJ(10, this.IsNotRichText);
      int j = i.a.a.b.b.a.q(11, this.abDi);
      int k = i.a.a.b.b.a.q(12, this.abDj);
      int m = i.a.a.b.b.a.cJ(13, this.DeleteFlag);
      int n = i.a.a.b.b.a.cJ(14, this.abDl);
      int i1 = i.a.a.a.c(15, 8, this.abDm);
      int i2 = i.a.a.b.b.a.cJ(16, this.abDn);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abDm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fdv localfdv = (fdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localfdv.Username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localfdv.Nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localfdv.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localfdv.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localfdv.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localfdv.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localfdv.abDh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localfdv.abDg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localfdv.abDA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localfdv.IsNotRichText = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localfdv.abDi = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localfdv.abDj = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localfdv.DeleteFlag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localfdv.abDl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            feb localfeb = new feb();
            if ((localObject != null) && (localObject.length > 0)) {
              localfeb.parseFrom((byte[])localObject);
            }
            localfdv.abDm.add(localfeb);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localfdv.abDn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdv
 * JD-Core Version:    0.7.0.1
 */