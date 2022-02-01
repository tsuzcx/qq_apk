package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apd
  extends com.tencent.mm.bx.a
{
  public String Glu;
  public int GmJ;
  public long Gmn;
  public String GnE;
  public String GnF;
  public apz GnG;
  public apg GnH;
  public apg GnI;
  public ape GnJ;
  public LinkedList<FinderContact> GnK;
  public int GnL;
  public int GnM;
  public String bVF;
  public long commentId;
  public int dDp;
  public String description;
  public int extFlag;
  public String fkx;
  public int hZE;
  public String headUrl;
  public long id;
  public int mediaType;
  public String objectNonceId;
  public long rIZ;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public apd()
  {
    AppMethodBeat.i(209330);
    this.GnK = new LinkedList();
    AppMethodBeat.o(209330);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.headUrl != null) {
        paramVarArgs.d(1, this.headUrl);
      }
      if (this.bVF != null) {
        paramVarArgs.d(2, this.bVF);
      }
      paramVarArgs.aS(3, this.GmJ);
      if (this.GnE != null) {
        paramVarArgs.d(4, this.GnE);
      }
      paramVarArgs.aS(5, this.hZE);
      if (this.thumbUrl != null) {
        paramVarArgs.d(6, this.thumbUrl);
      }
      paramVarArgs.aY(7, this.id);
      paramVarArgs.aY(8, this.rIZ);
      paramVarArgs.aY(9, this.commentId);
      paramVarArgs.aS(10, this.dDp);
      paramVarArgs.aS(11, this.extFlag);
      if (this.GnF != null) {
        paramVarArgs.d(12, this.GnF);
      }
      if (this.GnG != null)
      {
        paramVarArgs.lC(13, this.GnG.computeSize());
        this.GnG.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.d(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.d(16, this.replyNickname);
      }
      if (this.Glu != null) {
        paramVarArgs.d(17, this.Glu);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.d(19, this.username);
      }
      if (this.GnH != null)
      {
        paramVarArgs.lC(20, this.GnH.computeSize());
        this.GnH.writeFields(paramVarArgs);
      }
      if (this.GnI != null)
      {
        paramVarArgs.lC(21, this.GnI.computeSize());
        this.GnI.writeFields(paramVarArgs);
      }
      if (this.GnJ != null)
      {
        paramVarArgs.lC(22, this.GnJ.computeSize());
        this.GnJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.GnK);
      paramVarArgs.aS(24, this.GnL);
      paramVarArgs.aS(25, this.GnM);
      if (this.fkx != null) {
        paramVarArgs.d(26, this.fkx);
      }
      paramVarArgs.aY(27, this.Gmn);
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label2090;
      }
    }
    label2090:
    for (paramInt = f.a.a.b.b.a.e(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bVF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bVF);
      }
      i += f.a.a.b.b.a.bz(3, this.GmJ);
      paramInt = i;
      if (this.GnE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GnE);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.hZE);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.id) + f.a.a.b.b.a.p(8, this.rIZ) + f.a.a.b.b.a.p(9, this.commentId) + f.a.a.b.b.a.bz(10, this.dDp) + f.a.a.b.b.a.bz(11, this.extFlag);
      paramInt = i;
      if (this.GnF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GnF);
      }
      i = paramInt;
      if (this.GnG != null) {
        i = paramInt + f.a.a.a.lB(13, this.GnG.computeSize());
      }
      i += f.a.a.b.b.a.bz(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.replyNickname);
      }
      paramInt = i;
      if (this.Glu != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Glu);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.objectNonceId);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.username);
      }
      i = paramInt;
      if (this.GnH != null) {
        i = paramInt + f.a.a.a.lB(20, this.GnH.computeSize());
      }
      paramInt = i;
      if (this.GnI != null) {
        paramInt = i + f.a.a.a.lB(21, this.GnI.computeSize());
      }
      i = paramInt;
      if (this.GnJ != null) {
        i = paramInt + f.a.a.a.lB(22, this.GnJ.computeSize());
      }
      i = i + f.a.a.a.c(23, 8, this.GnK) + f.a.a.b.b.a.bz(24, this.GnL) + f.a.a.b.b.a.bz(25, this.GnM);
      paramInt = i;
      if (this.fkx != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.fkx);
      }
      i = f.a.a.b.b.a.p(27, this.Gmn);
      AppMethodBeat.o(169009);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GnK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apd localapd = (apd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localapd.headUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localapd.bVF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localapd.GmJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localapd.GnE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localapd.hZE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localapd.thumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localapd.id = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localapd.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localapd.commentId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localapd.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localapd.extFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localapd.GnF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapd.GnG = ((apz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localapd.mediaType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localapd.description = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localapd.replyNickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localapd.Glu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localapd.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localapd.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapd.GnH = ((apg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapd.GnI = ((apg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ape();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ape)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapd.GnJ = ((ape)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapd.GnK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 24: 
          localapd.GnL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 25: 
          localapd.GnM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169009);
          return 0;
        case 26: 
          localapd.fkx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169009);
          return 0;
        }
        localapd.Gmn = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apd
 * JD-Core Version:    0.7.0.1
 */