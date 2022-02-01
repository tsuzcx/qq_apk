package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.bx.a
{
  public String ToK;
  public TextStatusExtInfo Tqi;
  public LinkedList<String> Tqj;
  public boolean Tqk;
  public String Tql;
  public int Tqm;
  public int Tqn;
  public long Tqo;
  public boolean Tqp;
  public String Tqq;
  public String Tqr;
  public String errMsg;
  public String thumbPath;
  
  public bg()
  {
    AppMethodBeat.i(289892);
    this.Tqj = new LinkedList();
    AppMethodBeat.o(289892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289911);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Tqi != null)
      {
        paramVarArgs.qD(1, this.Tqi.computeSize());
        this.Tqi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Tqj);
      paramVarArgs.di(3, this.Tqk);
      if (this.Tql != null) {
        paramVarArgs.g(4, this.Tql);
      }
      if (this.thumbPath != null) {
        paramVarArgs.g(5, this.thumbPath);
      }
      paramVarArgs.bS(6, this.Tqm);
      paramVarArgs.bS(7, this.Tqn);
      paramVarArgs.bv(8, this.Tqo);
      paramVarArgs.di(9, this.Tqp);
      if (this.errMsg != null) {
        paramVarArgs.g(10, this.errMsg);
      }
      if (this.Tqq != null) {
        paramVarArgs.g(11, this.Tqq);
      }
      if (this.ToK != null) {
        paramVarArgs.g(12, this.ToK);
      }
      if (this.Tqr != null) {
        paramVarArgs.g(13, this.Tqr);
      }
      AppMethodBeat.o(289911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tqi == null) {
        break label928;
      }
    }
    label928:
    for (paramInt = i.a.a.a.qC(1, this.Tqi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.Tqj) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.Tql != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Tql);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.thumbPath);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.Tqm) + i.a.a.b.b.a.cJ(7, this.Tqn) + i.a.a.b.b.a.q(8, this.Tqo) + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.errMsg);
      }
      i = paramInt;
      if (this.Tqq != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Tqq);
      }
      paramInt = i;
      if (this.ToK != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ToK);
      }
      i = paramInt;
      if (this.Tqr != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Tqr);
      }
      AppMethodBeat.o(289911);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tqj.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289911);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            TextStatusExtInfo localTextStatusExtInfo = new TextStatusExtInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localTextStatusExtInfo.parseFrom((byte[])localObject);
            }
            localbg.Tqi = localTextStatusExtInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(289911);
          return 0;
        case 2: 
          localbg.Tqj.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(289911);
          return 0;
        case 3: 
          localbg.Tqk = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(289911);
          return 0;
        case 4: 
          localbg.Tql = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289911);
          return 0;
        case 5: 
          localbg.thumbPath = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289911);
          return 0;
        case 6: 
          localbg.Tqm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289911);
          return 0;
        case 7: 
          localbg.Tqn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289911);
          return 0;
        case 8: 
          localbg.Tqo = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(289911);
          return 0;
        case 9: 
          localbg.Tqp = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(289911);
          return 0;
        case 10: 
          localbg.errMsg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289911);
          return 0;
        case 11: 
          localbg.Tqq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289911);
          return 0;
        case 12: 
          localbg.ToK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289911);
          return 0;
        }
        localbg.Tqr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(289911);
        return 0;
      }
      AppMethodBeat.o(289911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bg
 * JD-Core Version:    0.7.0.1
 */