package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aju
  extends com.tencent.mm.bx.a
{
  public String Dkv;
  public String DlJ;
  public String DlK;
  public akd DlL;
  public dzh LxI;
  public dzh LxJ;
  public dzf LxK;
  public LinkedList<FinderContact> LxL;
  public int LxM;
  public String bNK;
  public long commentId;
  public String description;
  public int dtM;
  public int extFlag;
  public String headUrl;
  public int hgr;
  public long id;
  public int mediaType;
  public long objectId;
  public String objectNonceId;
  public int qpj;
  public String replyNickname;
  public String thumbUrl;
  public String username;
  
  public aju()
  {
    AppMethodBeat.i(203862);
    this.LxL = new LinkedList();
    AppMethodBeat.o(203862);
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
      if (this.bNK != null) {
        paramVarArgs.d(2, this.bNK);
      }
      paramVarArgs.aR(3, this.qpj);
      if (this.DlJ != null) {
        paramVarArgs.d(4, this.DlJ);
      }
      paramVarArgs.aR(5, this.hgr);
      if (this.thumbUrl != null) {
        paramVarArgs.d(6, this.thumbUrl);
      }
      paramVarArgs.aG(7, this.id);
      paramVarArgs.aG(8, this.objectId);
      paramVarArgs.aG(9, this.commentId);
      paramVarArgs.aR(10, this.dtM);
      paramVarArgs.aR(11, this.extFlag);
      if (this.DlK != null) {
        paramVarArgs.d(12, this.DlK);
      }
      if (this.DlL != null)
      {
        paramVarArgs.kX(13, this.DlL.computeSize());
        this.DlL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.mediaType);
      if (this.description != null) {
        paramVarArgs.d(15, this.description);
      }
      if (this.replyNickname != null) {
        paramVarArgs.d(16, this.replyNickname);
      }
      if (this.Dkv != null) {
        paramVarArgs.d(17, this.Dkv);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(18, this.objectNonceId);
      }
      if (this.username != null) {
        paramVarArgs.d(19, this.username);
      }
      if (this.LxI != null)
      {
        paramVarArgs.kX(20, this.LxI.computeSize());
        this.LxI.writeFields(paramVarArgs);
      }
      if (this.LxJ != null)
      {
        paramVarArgs.kX(21, this.LxJ.computeSize());
        this.LxJ.writeFields(paramVarArgs);
      }
      if (this.LxK != null)
      {
        paramVarArgs.kX(22, this.LxK.computeSize());
        this.LxK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.LxL);
      paramVarArgs.aR(24, this.LxM);
      AppMethodBeat.o(169009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.headUrl == null) {
        break label1942;
      }
    }
    label1942:
    for (paramInt = f.a.a.b.b.a.e(1, this.headUrl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bNK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bNK);
      }
      i += f.a.a.b.b.a.bA(3, this.qpj);
      paramInt = i;
      if (this.DlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DlJ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.hgr);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.q(7, this.id) + f.a.a.b.b.a.q(8, this.objectId) + f.a.a.b.b.a.q(9, this.commentId) + f.a.a.b.b.a.bA(10, this.dtM) + f.a.a.b.b.a.bA(11, this.extFlag);
      paramInt = i;
      if (this.DlK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DlK);
      }
      i = paramInt;
      if (this.DlL != null) {
        i = paramInt + f.a.a.a.kW(13, this.DlL.computeSize());
      }
      i += f.a.a.b.b.a.bA(14, this.mediaType);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.description);
      }
      i = paramInt;
      if (this.replyNickname != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.replyNickname);
      }
      paramInt = i;
      if (this.Dkv != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Dkv);
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
      if (this.LxI != null) {
        i = paramInt + f.a.a.a.kW(20, this.LxI.computeSize());
      }
      paramInt = i;
      if (this.LxJ != null) {
        paramInt = i + f.a.a.a.kW(21, this.LxJ.computeSize());
      }
      i = paramInt;
      if (this.LxK != null) {
        i = paramInt + f.a.a.a.kW(22, this.LxK.computeSize());
      }
      paramInt = f.a.a.a.c(23, 8, this.LxL);
      int j = f.a.a.b.b.a.bA(24, this.LxM);
      AppMethodBeat.o(169009);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LxL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aju localaju = (aju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169009);
          return -1;
        case 1: 
          localaju.headUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 2: 
          localaju.bNK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 3: 
          localaju.qpj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169009);
          return 0;
        case 4: 
          localaju.DlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 5: 
          localaju.hgr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169009);
          return 0;
        case 6: 
          localaju.thumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 7: 
          localaju.id = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169009);
          return 0;
        case 8: 
          localaju.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169009);
          return 0;
        case 9: 
          localaju.commentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169009);
          return 0;
        case 10: 
          localaju.dtM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169009);
          return 0;
        case 11: 
          localaju.extFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169009);
          return 0;
        case 12: 
          localaju.DlK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.DlL = ((akd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 14: 
          localaju.mediaType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169009);
          return 0;
        case 15: 
          localaju.description = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 16: 
          localaju.replyNickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 17: 
          localaju.Dkv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 18: 
          localaju.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 19: 
          localaju.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169009);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.LxI = ((dzh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.LxJ = ((dzh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.LxK = ((dzf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.LxL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169009);
          return 0;
        }
        localaju.LxM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169009);
        return 0;
      }
      AppMethodBeat.o(169009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aju
 * JD-Core Version:    0.7.0.1
 */