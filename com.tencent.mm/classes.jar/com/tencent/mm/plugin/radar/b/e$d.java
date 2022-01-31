package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.brg;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
public abstract interface e$d
{
  public abstract void a(int paramInt1, int paramInt2, LinkedList<brg> paramLinkedList);
  
  public abstract void b(int paramInt1, int paramInt2, LinkedList<brd> paramLinkedList);
  
  public abstract void ko(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.d
 * JD-Core Version:    0.7.0.1
 */