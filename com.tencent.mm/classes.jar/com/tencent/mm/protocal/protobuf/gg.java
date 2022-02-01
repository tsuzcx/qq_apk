package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gg
  extends erp
{
  public int YHV;
  public int YHX;
  public long YHY;
  public int YHt;
  public int YHu;
  public int YHv;
  public long YHw;
  public String content;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      paramVarArgs.bv(5, this.YHY);
      paramVarArgs.bS(6, this.wuj);
      paramVarArgs.bS(7, this.YHV);
      if (this.title != null) {
        paramVarArgs.g(8, this.title);
      }
      paramVarArgs.bS(9, this.scene);
      paramVarArgs.bS(10, this.YHt);
      paramVarArgs.bS(11, this.YHu);
      paramVarArgs.bS(12, this.YHv);
      if (this.session_id != null) {
        paramVarArgs.g(13, this.session_id);
      }
      paramVarArgs.bv(14, this.YHw);
      paramVarArgs.bS(15, this.YHX);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label936;
      }
    }
    label936:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.content);
      }
      i = i + i.a.a.b.b.a.q(5, this.YHY) + i.a.a.b.b.a.cJ(6, this.wuj) + i.a.a.b.b.a.cJ(7, this.YHV);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.title);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.scene) + i.a.a.b.b.a.cJ(10, this.YHt) + i.a.a.b.b.a.cJ(11, this.YHu) + i.a.a.b.b.a.cJ(12, this.YHv);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.session_id);
      }
      i = i.a.a.b.b.a.q(14, this.YHw);
      int j = i.a.a.b.b.a.cJ(15, this.YHX);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gg localgg = (gg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localgg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localgg.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localgg.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localgg.YHY = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localgg.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localgg.YHV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localgg.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localgg.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localgg.YHt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localgg.YHu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localgg.YHv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localgg.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localgg.YHw = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(103199);
          return 0;
        }
        localgg.YHX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */