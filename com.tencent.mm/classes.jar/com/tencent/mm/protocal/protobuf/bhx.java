package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bhx
  extends com.tencent.mm.cd.a
{
  public String RLN;
  public awm SSA;
  public String SSp;
  public int SSq;
  public int SSr;
  public long SSs;
  public int SSt;
  public b SSu;
  public int SSv;
  public int SSw;
  public String SSx;
  public String SSy;
  public int SSz;
  public long object_id;
  public String object_nonce_id;
  public b tabTipsByPassInfo;
  public int tab_type;
  public int update_time;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SSp != null) {
        paramVarArgs.f(1, this.SSp);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.aY(3, this.SSq);
      paramVarArgs.bm(4, this.object_id);
      paramVarArgs.aY(5, this.SSr);
      paramVarArgs.aY(6, this.update_time);
      paramVarArgs.bm(7, this.SSs);
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.c(8, this.tabTipsByPassInfo);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.f(9, this.object_nonce_id);
      }
      paramVarArgs.aY(10, this.tab_type);
      paramVarArgs.aY(11, this.SSt);
      if (this.SSu != null) {
        paramVarArgs.c(12, this.SSu);
      }
      paramVarArgs.aY(13, this.SSv);
      paramVarArgs.aY(14, this.SSw);
      if (this.RLN != null) {
        paramVarArgs.f(15, this.RLN);
      }
      if (this.SSx != null) {
        paramVarArgs.f(16, this.SSx);
      }
      if (this.SSy != null) {
        paramVarArgs.f(17, this.SSy);
      }
      paramVarArgs.aY(18, this.SSz);
      if (this.SSA != null)
      {
        paramVarArgs.oE(19, this.SSA.computeSize());
        this.SSA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(205717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SSp == null) {
        break label1224;
      }
    }
    label1224:
    for (paramInt = g.a.a.b.b.a.g(1, this.SSp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i = i + g.a.a.b.b.a.bM(3, this.SSq) + g.a.a.b.b.a.p(4, this.object_id) + g.a.a.b.b.a.bM(5, this.SSr) + g.a.a.b.b.a.bM(6, this.update_time) + g.a.a.b.b.a.p(7, this.SSs);
      paramInt = i;
      if (this.tabTipsByPassInfo != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.tabTipsByPassInfo);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.object_nonce_id);
      }
      i = i + g.a.a.b.b.a.bM(10, this.tab_type) + g.a.a.b.b.a.bM(11, this.SSt);
      paramInt = i;
      if (this.SSu != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.SSu);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.SSv) + g.a.a.b.b.a.bM(14, this.SSw);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RLN);
      }
      i = paramInt;
      if (this.SSx != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.SSx);
      }
      paramInt = i;
      if (this.SSy != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SSy);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.SSz);
      paramInt = i;
      if (this.SSA != null) {
        paramInt = i + g.a.a.a.oD(19, this.SSA.computeSize());
      }
      AppMethodBeat.o(205717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bhx localbhx = (bhx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205717);
          return -1;
        case 1: 
          localbhx.SSp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 2: 
          localbhx.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 3: 
          localbhx.SSq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 4: 
          localbhx.object_id = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(205717);
          return 0;
        case 5: 
          localbhx.SSr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 6: 
          localbhx.update_time = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 7: 
          localbhx.SSs = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(205717);
          return 0;
        case 8: 
          localbhx.tabTipsByPassInfo = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(205717);
          return 0;
        case 9: 
          localbhx.object_nonce_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 10: 
          localbhx.tab_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 11: 
          localbhx.SSt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 12: 
          localbhx.SSu = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(205717);
          return 0;
        case 13: 
          localbhx.SSv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 14: 
          localbhx.SSw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        case 15: 
          localbhx.RLN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 16: 
          localbhx.SSx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 17: 
          localbhx.SSy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205717);
          return 0;
        case 18: 
          localbhx.SSz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205717);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          awm localawm = new awm();
          if ((localObject != null) && (localObject.length > 0)) {
            localawm.parseFrom((byte[])localObject);
          }
          localbhx.SSA = localawm;
          paramInt += 1;
        }
        AppMethodBeat.o(205717);
        return 0;
      }
      AppMethodBeat.o(205717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhx
 * JD-Core Version:    0.7.0.1
 */